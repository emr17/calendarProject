import axios from "axios";


export default class GatewayService {

    addUser({}){
        // apimizn adresini yazıcaz
        axios.post("http://localhost:5555/gateway/user/add")
    }

    getAllUsers(){
        return axios.get("http://localhost:5555/gateway/user/getall")
    }

    findByEmail(email){
        return axios.get("http://localhost:5555/gateway/user/findbyemail?email="+ email)
    }

    saveEvent({}){
        // apimizn adresini yazıcaz
        axios.post("http://localhost:5555/gateway/calendar")
    }

    getAllEventsOfUser(userId){
        return axios.get("http://localhost:5555/gateway/calendar/" + userId)
    }

    getAllEventsOfUser(eventId){
        return axios.delete("http://localhost:5555/gateway/calendar/" + eventId)
    }





    




}
