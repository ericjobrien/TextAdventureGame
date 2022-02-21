package com.revature.model;

import com.revature.collections.GenericArrayList;
import com.revature.dao.MonsterDAO;


public class Monster {

    int monster_id;
    String type_of_monster;
    int max_health;
    int current_health;
    int attack_damage;
    int potion_drop_chance;

    public Monster() {
    }

    public Monster(int monster_id, String type_of_monster, int max_health, int current_health, int attack_damage, int potion_drop_chance) {
        this.monster_id = monster_id;
        this.type_of_monster = type_of_monster;
        this.max_health = max_health;
        this.current_health = current_health;
        this.attack_damage = attack_damage;
        this.potion_drop_chance = potion_drop_chance;
    }

    public int getMonster_id() {
        return monster_id;
    }

    public void setMonster_id(int monster_id) {
        this.monster_id = monster_id;
    }

    public String getType_of_monster() {
        return type_of_monster;
    }

    public void setType_of_monster(String type_of_monster) {
        this.type_of_monster = type_of_monster;
    }

    public int getMax_health() {
        return max_health;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public int getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(int current_health) {
        this.current_health = current_health;
    }

    public int getAttack_damage() {
        return attack_damage;
    }

    public void setAttack_damage(int attack_damage) {
        this.attack_damage = attack_damage;
    }

    public int getPotion_drop_chance() {
        return potion_drop_chance;
    }

    public void setPotion_drop_chance(int potion_drop_chance) {
        this.potion_drop_chance = potion_drop_chance;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "monster_id=" + monster_id +
                ", type_of_monster='" + type_of_monster + '\'' +
                ", max_health=" + max_health +
                ", current_health=" + current_health +
                ", attack_damage=" + attack_damage +
                ", potion_drop_chance=" + potion_drop_chance +
                '}';
    }

    public static Monster findByType(String monsterType) {

        MonsterDAO monsterDAO = new MonsterDAO();
        GenericArrayList allMonsters = monsterDAO.getAllMonsters();

        Monster[] monsterArray = new Monster[monsterDAO.getMonsterCount()];

        monsterArray = (Monster[]) allMonsters.getGenericArray();

        for(int i = 0; i < monsterArray.length; i++) {
            String monsterString = monsterArray[i].getType_of_monster();
            if(monsterType.compareTo(monsterString) == 0) {
                return monsterArray[i];
            } else if(monsterType.compareTo(monsterString) != 0){
                continue;
            } else {
                System.out.println("No such monster exists");
            }

       }

        return null;
    }
}
