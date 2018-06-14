/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDelZapatoBlanco.util;

/**
 *
 * @author Víctor Manuel
 */
//Edición para GitHub
public class Kid {
    private short id;
    private String name;
    private short age;
    private Kid nextKid;
    private Kid previousKid;

    public Kid(short id, String name, short age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Kid getNextKid() {
        return nextKid;
    }

    public void setNextKid(Kid nextKid) {
        this.nextKid = nextKid;
    }

    public Kid getPreviousKid() {
        return previousKid;
    }

    public void setPreviousKid(Kid previousKid) {
        this.previousKid = previousKid;
    }
    
}
