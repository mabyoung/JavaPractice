package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class DogCat {
    public class Pet{
        private String type;
        Pet(String type){
            this.type = type;
        }
        public String getPetType(){
            return this.type;
        }
    }

    public class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }

    public class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }

    public static class PetEnterQueue{
        private Pet pet;
        private long count;
        PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return this.count;
        }
        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private long count;
        public DogCatQueue(){
            this.dogQueue = new LinkedList<>();
            this.catQueue = new LinkedList<>();
            this.count = 0;
        }
        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                this.dogQueue.add(new PetEnterQueue(pet, this.count++));
            }else if(pet.getPetType().equals("cat")){
                this.catQueue.add(new PetEnterQueue(pet, this.count++));
            }else {
                throw new RuntimeException("not cat or dog");
            }
        }
        public Dog pollDog(){
            if (!dogQueue.isEmpty()){
                return (Dog) this.dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty！");
            }
        }
        public Cat pollCat(){
            if (!catQueue.isEmpty()){
                return (Cat) this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty! ");
            }
        }
        public Pet pollAll(){
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
                if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()){
                    return this.dogQueue.poll().getPet();
                } else {
                    return this.catQueue.poll().getPet();
                }
            } else if (!this.dogQueue.isEmpty()){
                return this.dogQueue.poll().getPet();
            } else if (!this.catQueue.isEmpty()){
                return this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("err, no cat or dog");
            }
        }
    }
}
