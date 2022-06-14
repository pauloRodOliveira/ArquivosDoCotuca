import { getCustomRepository } from "typeorm";
import { TagsRepositories } from "../repositories/TagsRepositories";

class CreateTagService{
  async execute(name: string){
    const tagsRepositories = getCustomRepository(TagsRepositories);

    //verificação de nome da tag
    if(!name){
      throw new Error("Incorrect tag name.");
    }

    //verifica se ela já existe
    const tagAlreadyExists = await tagsRepositories.findOne({name});

    if(tagAlreadyExists){
      throw new Error("TagAlreadyExists.");
    }

    //cria a tag
    const tag = tagsRepositories.create({
      name
    });

    //salva a tag no repositório
    await tagsRepositories.save(tag);

    return tag;
  }
}

export {CreateTagService}