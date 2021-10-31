package pr1;

import java.util.Scanner;

public class Animal extends Main{

    String name; //для назви безпосередньо тваринок
    int age; //для визначення віку тваринки (приставка baby or adult);
    int mood; //для визначення настрою (0-поганий,1-спокійний,2-злий);
    int voiceVolume; //для визначення гучності голосу (0-мовчить,1-тихий,2-гучний);

    static String[] animalNames = {"John", "Hannah", "Kurt", "Elizabeth", "Paolo","Jinn"};
    static String[] animalActionArray = {"sleeping","drinking","playing","trying to break trough the cage","being cute"};

    static int rdAnimalName = random.rdAnimalName();//блок визначення рандомних параметрів тваринок.
    static String animalName = animalNames[rdAnimalName];
    static int rdAction = random.rdAnimalAction();
    static String animalAction = animalActionArray[rdAction];
    static int animalAge = random.rdAnimalAge();

//    Animal(String name,int age,int mood,String animalAction,int voiceVolume){
//        this.name = name;
//        this.age = age;
//        this.mood = mood;
//        this.animalAction = animalAction;
//        this.voiceVolume = voiceVolume;
//    }

    public static void visitAnAnimal(){
        Scanner sc = new Scanner(System.in);
        int animalAnswer = sc.nextInt();
        if(animalAnswer == 1){
            animaGeneralInfo("panda");
            }
        else if (animalAnswer == 2){
            animaGeneralInfo("lion");
        }

    }

    static void animaGeneralInfo(String currentAnimalName){
        System.out.println("You're entering into the " + currentAnimalName + "'s enclosure\n" +
                "It's name is "+ animalName +" and now it's "+ animalAction +".");
        if (animalAge<10){
            System.out.println("Now we're looking at baby-"+ currentAnimalName +"!How sweet!\n" +
                    "He is "+animalAge+" years old!");
        }
        else if(animalAge>=10 && animalAge<=20){
            System.out.println("Now we're looking at teenager-"+ currentAnimalName +"!How cool!\n" +
                    "He is "+animalAge+" years old!");
        }
        else if (animalAge>20){
            System.out.println("Now we're having a deal with adult lion!So precious!\n" +
                    "He is "+animalAge+" years old!");
        }
    }

}
