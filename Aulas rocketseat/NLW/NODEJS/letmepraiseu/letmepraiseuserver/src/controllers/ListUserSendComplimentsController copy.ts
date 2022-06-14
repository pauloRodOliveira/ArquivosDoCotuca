import {Request, Response} from "express";
import { ListUserReceiveComplimentsService } from "../services/ListUserReceiveComplimentsService";

class ListUserSendComplimentsController{
    async handle(request: Request, response: Response){
        const {user_id} = request;

        const listUserReceiveComplimentsService = new ListUserReceiveComplimentsService();

        const compliments = listUserReceiveComplimentsService.execute(user_id);

        return response.json(compliments);
    }
}

export {ListUserSendComplimentsController}