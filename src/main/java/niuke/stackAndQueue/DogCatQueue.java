package niuke.stackAndQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by wq on 16-5-26.
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ ;
    private Queue<PetEnterQueue> catQ ;
    private int count;

    public DogCatQueue(){
        this.count = 0 ;
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
    }

    public void add(Pet pet){
        if(pet.getType().equals("dog")){
            dogQ.add(new PetEnterQueue(pet,count++));
        }else{
            catQ.add(new PetEnterQueue(pet,count++));
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty(){
        return this.catQ.isEmpty();
    }

    public Dog pollDog(){
        if(isDogEmpty()){
            throw new RuntimeException("dog queue is empty");
        }else{
            return (Dog)this.dogQ.poll().getPet();
        }
    }

    public Cat pollCat(){
        if(isDogEmpty()){
            throw new RuntimeException("dog queue is empty");
        }else{
            return (Cat)this.catQ.poll().getPet();
        }
    }

    public Pet pollAll(){
        if(!isCatEmpty() && !isDogEmpty()){
            if(this.catQ.peek().getCount() < this.dogQ.peek().getCount()){
                return this.catQ.poll().getPet();
            }else{
                return this.dogQ.poll().getPet();
            }
        }else if(!isCatEmpty()){
            return this.catQ.poll().getPet();
        }else if(!isDogEmpty()){
            return this.dogQ.poll().getPet();
        }else{
            throw new RuntimeException("queue is Empty");
        }
    }

}
