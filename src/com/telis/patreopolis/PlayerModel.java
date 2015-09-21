package com.telis.patreopolis;

public class PlayerModel {

    public int playerId;
    public String name;
    public int location;
    public int round;
    public int money;
    public boolean superBonusFlag;
    public boolean patranian;

     PlayerModel(int inId) {
        playerId = inId;
        name = "Παίκτης " + playerId;
        money = 150;
        location = 0;
        superBonusFlag = true;
        round = 0;

    }
     
     
    public boolean isSuperBonusFlag() {
        return superBonusFlag;
    }

    public void setSuperBonusFlag(boolean superBonusFlag) {
        this.superBonusFlag = superBonusFlag;
    }

    public int getRound() {
            return round;
    }

    public void setRound(int round) {
            this.round = round;
    }
    public int getLocation() {
        return location;
    }

    public void setLocation(int inLocation) {
        location = inLocation;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getMoney() {
        return money;
    }

    public void deductMoney(int debit)
    {
        money = money - debit;
    }

    public void addMoney(int credit)
    {
        money = money + credit;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }




//    public void setMoney(int money) {
//        this.money = money;
//    }




//    public void setPlayerId(int playerId) {
//        this.playerId = playerId;
//    }

    public boolean isPatranian() {
        return patranian;
    }

    public void setPatranian(boolean patranian) {
        this.patranian = patranian;
    }
}
