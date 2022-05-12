import axios from "axios";
import format from "date-fns/format";
import getDay from "date-fns/getDay";
import parse from "date-fns/parse";
import startOfWeek from "date-fns/startOfWeek";
import React, { useEffect, useState } from "react";
import { Calendar, dateFnsLocalizer } from "react-big-calendar";
import "react-big-calendar/lib/css/react-big-calendar.css";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useParams } from "react-router-dom";
import { useHistory } from "react-router-dom";
import GatewayService from "../services/gatewayService";

const locales = {
    "en-US": require("date-fns/locale/en-US"),
};
const localizer = dateFnsLocalizer({
    format,
    parse,
    startOfWeek,
    getDay,
    locales,
});

const events = [
    {
        title: "Big Meeting",
        allDay: true,
        start: new Date(2021, 6, 0),
        end: new Date(2021, 6, 0),
    },
    {
        title: "Vacation",
        start: new Date(2021, 6, 7),
        end: new Date(2021, 6, 10),
    },
    {
        title: "Conference",
        start: new Date(2021, 6, 20),
        end: new Date(2021, 6, 23),
    },
];

function Aaa() {
    let { id } = useParams();
    console.log(id);

    const [newEvent, setNewEvent] = useState({userId:id, description: "", startDate: "", endDate: "" });
    
    

    
    const [evs, setevs] = useState([]); // use state içi ilk state oluyor

  useEffect(()=>{
    
    axios.get('http://localhost:5555/gateway/calendar/'+id)
    .then(result=>setevs(result.data))
  },[])


    function handleAddEvent() {
    console.log(evs);
      console.log(newEvent);
      axios.post('http://localhost:5555/gateway/calendar', newEvent)
                    .then(console.log("Eklendi"));


    }

    return (
        <div className="App">
            <h1>Calendar</h1>
            <h2>Add New Event</h2>
            <div>
                <input type="text" placeholder="Add Title" style={{ width: "20%", marginRight: "10px" }} value={newEvent.description} onChange={(e) => setNewEvent({ ...newEvent, description: e.target.value })} />
                <DatePicker placeholderText="Start Date" style={{ marginRight: "10px" }} selected={newEvent.startDate} onChange={(startDate) => setNewEvent({ ...newEvent, startDate })} />
                <DatePicker placeholderText="End Date" selected={newEvent.endDate} onChange={(endDate) => setNewEvent({ ...newEvent, endDate })} />
                <button stlye={{ marginTop: "10px" }} onClick={handleAddEvent}>
                    Add Event
                </button>
            </div>
            <Calendar localizer={localizer} events={evs} startAccessor="start" endAccessor="end" style={{ height: 500, margin: "50px" }} />
        </div>
    );
}

export default Aaa;