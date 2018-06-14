/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoDelZapatoBlanco.util;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author Víctor Manuel
 */
public class ListKids {
 private Kid firstOne;
 private Kid lastOne;
 private short size;
 private short position;
 private JTextArea jTextArea  = new JTextArea();

    public ListKids(JTextArea jTextArea) {
        firstOne = lastOne = null;
        size = 0;
        position = -1;
        this.jTextArea = jTextArea;
    }
    public void addKid(String name, short age){
        position++;
        size++;
        Kid newKid = new Kid(position,name,age);
        lastOne = newKid;
        if(firstOne == null){
            firstOne = newKid;
            firstOne.setNextKid(firstOne);
            firstOne.setPreviousKid(firstOne);
        }else{
            Kid auxKid = firstOne;
            while(auxKid.getNextKid()!=firstOne){
                auxKid = auxKid.getNextKid();
            }
            auxKid.setNextKid(lastOne);
            lastOne.setPreviousKid(auxKid);
            auxKid.getNextKid().setNextKid(firstOne);
            firstOne.setPreviousKid(auxKid.getNextKid());
        }
    }
    public void firstMove(){
    int firstStep = (int)(Math.random()*(size*2))+1;
    int random = firstStep;
        Kid aux = firstOne;
        if(aux != null){
            while(firstStep != 1){
                aux = aux.getNextKid();
                firstStep--;
            }
            firstOne = aux;
            jTextArea.append("Se ha iniciado el recorrido\n");
            jTextArea.append("El número aleatorio es: "+String.valueOf(random)+"\n");
            jTextArea.append("Se empieza a contar a partir de: "+aux.getName()+" con "+aux.getAge()+" años\n");
            moveToLeft(aux.getAge());
        }
    }
    public void moveToLeft(short lastOneAge){
        Kid aux = firstOne;
        if(aux != null){
            while(lastOneAge != 0){
                aux = aux.getPreviousKid();
                lastOneAge--;
            }
            System.out.println(size);
            this.jTextArea.append("El niño a la izquierda es "+aux.getName()+" con "+aux.getAge()+"años \n");
            deleteKid(aux.getName());
            if (firstOne != null) firstOne = aux;
            moveToRight(aux.getAge());
            
        }
    }
    public void moveToRight(short lastOneAge){
        Kid aux = firstOne;
        System.out.println(lastOneAge+" a la izquierda");        
        if(aux != null){
            while(lastOneAge !=0){
                aux = aux.getNextKid();
                lastOneAge--;
            }
            System.out.println(size);
            this.jTextArea.append("El niño a la derecha es "+aux.getName()+" con "+aux.getAge()+"\n");
            deleteKid(aux.getName());
            if (firstOne != null) firstOne = aux;
            moveToLeft(aux.getAge());
            
        }
    }
   
    public void deleteKid(String name){
        if(firstOne!=null){ 
            Kid auxKid = firstOne;
            boolean found = false;
            while(found == false){
                if(auxKid.getName().equals(name)){
                    auxKid.getPreviousKid().setNextKid(auxKid.getNextKid());
                    auxKid.getNextKid().setPreviousKid(auxKid.getPreviousKid());
                    size--;
                    firstOne = auxKid;
                    found = true;
                }
                
                auxKid = auxKid.getNextKid();
                if(searchForAWinner() == true) {
                    found = true;
                    firstOne = null;
                    lastOne = null;
                    auxKid = null;
                } 
            }
        }
        }
    public boolean searchForAWinner(){
        if(firstOne.getNextKid().getName().equals(firstOne.getName())){
            JOptionPane.showMessageDialog(null, firstOne.getName()+" ha ganado!");
            return true;
        }else{
        return false;
        }
    }
    public void printList(){
        if(firstOne!=null){
            Kid aux = firstOne;
            do{
                System.out.println(""+aux.getName());
                aux = aux.getNextKid();
            }while(aux!=firstOne);
            System.out.println();
        }else{
        }
    }
    public Kid getFirstOne() {
        return firstOne;
    }

    public Kid getLastOne() {
        return lastOne;
    }

    public short getSize() {
        return size;
    }

    public short getPosition() {
        return position;
    }

}
