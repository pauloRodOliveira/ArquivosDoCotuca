import "reflect-metadata";
import "express-async-errors";
import express, { request, response } from "express";
import {router} from "./routers";
import { Request, Response, NextFunction } from "express";
import cors from "cors";

import "./database";

const app = express();

app.use(cors());
app.use(express.json());

app.use(router);

app.use((err: Error, request: Request, response: Response, next: NextFunction) => {
  if(err instanceof Error){
    return response.status(400).json({err: err.message});
  }

  return response.status(500).json({
    status: "error",
    message: "Internal Server Error"
  });
});

const PORT = 3000;

app.listen(PORT, () => console.log(`Server is running in port: ${PORT}`));
