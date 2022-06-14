import { compare } from "bcryptjs";
import { sign } from "jsonwebtoken";
import { getCustomRepository } from "typeorm";
import { UsersRepositories } from "../repositories/UsersRepositories";

interface IAuthenticateUserService {
  email: string,
  password: string
}

class AuthenticateUserService{
  async execute({email, password}: IAuthenticateUserService){
    const usersRepositories = getCustomRepository(UsersRepositories);

    //Verificar se email já existe
    const user = await usersRepositories.findOne({email});

    if(!user){
      throw new Error("Email or Password incorrect.");
    }

    //Verificar se a senha está correta (para isso é necessário descriptografar)
    const passwordMatch = await compare(password, user.password);

    if(!passwordMatch){
      throw new Error("Email or Password incorrect.");
    }

    //Gerar o token
    const token = await sign({
      email: user.email
    }, "9810aee05107a245061d83e4c7cda3c5", {
      subject: user.id,
      expiresIn: "1d"
    });

    return token;
  }
}

export { AuthenticateUserService }