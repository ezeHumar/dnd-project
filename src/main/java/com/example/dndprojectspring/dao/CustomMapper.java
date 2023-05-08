package com.example.dndprojectspring.dao;

public interface CustomMapper<Entity, Dto>{

    public Dto toDto(Entity entity);

    public Entity toEntity(Dto dto);
}
