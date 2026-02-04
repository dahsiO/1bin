// import dependencies
const cors = require('cors');
import express from "express";
import {Response, Request} from 'express';
import {doctorsController} from './controllers/doctors.controller';

// creates an express app
export const app = express();
app.use(cors());
app.use(express.json());

// defines a dummy route
app.get('/', (req: Request, res: Response) => {
  res.send("bonjour tous le monde");
});

// use the controller to use the route
app.use('/doctors', doctorsController);
