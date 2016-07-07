package niuke.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import static net.mindview.util.Print.*;

/**
 * Created by wq on 16-5-26.
 */
public class DogCatQueue2 {
    private Queue<Pet> dogAndCatQueue;

    public DogCatQueue2(){
        this.dogAndCatQueue = new LinkedList<Pet>();
    }

    public void add(Pet pet){
        dogAndCatQueue.add(pet);
    }

    public boolean isEmpty(){
        return this.dogAndCatQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        if(!isEmpty()){
            for(Pet pet : dogAndCatQueue){
                if(pet.getType().equals("dog")){
                    return false;
                }
            }
        }else{
            throw new RuntimeException("queue is empty");
        }
        return true;
    }

    public boolean isCatEmpty(){
        if(!isEmpty()){
            for(Pet pet : dogAndCatQueue){
                if(pet.getType().equals("cat")){
                    return false;
                }
            }
        }else{
            throw new RuntimeException("queue is empty");
        }
        return true;
    }

    public Pet pollAll(){
        if(dogAndCatQueue.isEmpty()) throw new RuntimeException("queue is empty");

        return dogAndCatQueue.poll();
    }

    public Dog pollDog(){
        print("dog poll");
        if(!isEmpty()){
            for(Pet pet : dogAndCatQueue){
                if(pet.getType().equals("dog")){
                    Dog dog = (Dog)pet;
                    dogAndCatQueue.remove(dog);
                    return dog;
                }
            }
        }
        throw new RuntimeException("queue is not dog  / queue is empty");
    }

    public Cat pollCat(){
        if(!isEmpty()){
            for(Pet pet : dogAndCatQueue){
                if(pet.getType().equals("cat")){
                    Cat cat = (Cat)pet;
                    dogAndCatQueue.remove(cat);
                    return cat;
                }
            }
        }
        throw new RuntimeException("queue is not cat  / queue is empty");
    }
    public static void main(String args[]){
        DogCatQueue2 dcQ =   new DogCatQueue2();
        dcQ.add(new Cat());
        dcQ.add(new Cat());
        dcQ.add(new Dog());
        dcQ.add(new Cat());
        dcQ.add(new Cat());

        Dog dog = dcQ.pollDog();
        Pet pet = dcQ.pollAll();
        print(dog);
        print(pet);

//        print(dcQ.isCatEmpty());
//        print(dcQ.isDogEmpty());

    }
}
