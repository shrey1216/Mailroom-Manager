//@author Shreyan Wankavala
//112634232
//Recitation 01

import java.util.Scanner;

public class MailroomManager {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nWelcome to the Irving Mailroom Manager. " +
                "You can try to make it better, but the odds are stacked against you. It is day 0\n");

        PackageStack one = new PackageStack(); //A-G
        PackageStack two = new PackageStack(); //H-J
        PackageStack three = new PackageStack(); //K-M
        PackageStack four = new PackageStack(); //N-R
        PackageStack five = new PackageStack(); //S-Z
        PackageStack floor = new PackageStack(0);
        PackageStack rndm = new PackageStack(0);

        int day = 0;
        String choice = "";


        while(!choice.equals("Q")){
            System.out.print("\n\nMenu:\n" +
                    "     D) Deliver a package\n" +
                    "     G) Get someone's package\n" +
                    "     T) Make it tomorrow\n" +
                    "     P) Print the stacks\n" +
                    "     M) Move a package from one stack to another\n" +
                    "     F) Find packages in the wrong stack and move to floor\n" +
                    "     L) List all packages awaiting a user\n" +
                    "     E) Empty the floor.\n" +
                    "     Q) Quit\n");
            System.out.print("\nPlease select an option:");
            choice = scan.nextLine();
            choice = choice.toUpperCase();

            if(choice.equals("D")){
                System.out.print("Please enter the recipient name:");
                String name = scan.nextLine();
                System.out.print("Please enter the weight (lbs): ");
                double weight = Double.parseDouble(scan.nextLine());
                Package pack = new Package(name,day,weight);
                System.out.print("\n A " + weight + " lb package is awaiting pickup by " + name + "\n");
                name = name.toUpperCase();
                char letter = name.charAt(0);
                if(letter >= 65 && letter <= 71){
                    if(!one.isFull()) {
                        one.push(pack);
                    }
                    else if(!two.isFull()){
                        two.push(pack);
                    }
                    else if(!three.isFull()){
                        three.push(pack);
                    }
                    else if(!four.isFull()){
                        four.push(pack);
                    }
                    else if(!five.isFull()){
                        five.push(pack);
                    }
                    else{
                        floor.pushFloor(pack);
                    }
                }
                else if(letter >= 72 && letter <= 74){
                    if(!two.isFull()) {
                        two.push(pack);
                    }
                    else if(!one.isFull()){
                        one.push(pack);
                    }
                    else if(!three.isFull()){
                        three.push(pack);
                    }
                    else if(!four.isFull()){
                        four.push(pack);
                    }
                    else if(!five.isFull()){
                        five.push(pack);
                    }
                    else{
                        floor.pushFloor(pack);
                    }
                }
                else if(letter >= 75 && letter <= 77){
                    if(!three.isFull()) {
                        three.push(pack);
                    }
                    else if(!two.isFull()){
                        two.push(pack);
                    }
                    else if(!four.isFull()){
                        four.push(pack);
                    }
                    else if(!one.isFull()){
                        one.push(pack);
                    }
                    else if(!five.isFull()){
                        five.push(pack);
                    }
                    else{
                        floor.pushFloor(pack);
                    }
                }
                else if(letter >= 78 && letter <= 82){
                    if(!four.isFull()) {
                        four.push(pack);
                    }
                    else if(!three.isFull()){
                        three.push(pack);
                    }
                    else if(!five.isFull()){
                        five.push(pack);
                    }
                    else if(!two.isFull()){
                        two.push(pack);
                    }
                    else if(!one.isFull()){
                        one.push(pack);
                    }
                    else{
                        floor.pushFloor(pack);
                    }
                }
                else if(letter >= 83 && letter <= 90){
                    if(!five.isFull()) {
                        five.push(pack);
                    }
                    else if(!four.isFull()){
                        four.push(pack);
                    }
                    else if(!three.isFull()){
                        three.push(pack);
                    }
                    else if(!two.isFull()){
                        two.push(pack);
                    }
                    else if(!one.isFull()){
                        one.push(pack);
                    }
                    else{
                        floor.pushFloor(pack);
                    }
                }
                else{
                    floor.pushFloor(pack);
                }
            }
            else if(choice.equals("G")){
                boolean found = false;
                System.out.print("Please enter the recipient name: ");
                String name = scan.nextLine();

                int oneSize = one.getSize() - 1;
                for(int i = oneSize; i >= 0; i--){
                    if(one.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = one.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            floor.pushFloor(one.pop());
                        }
                        System.out.print("\nMove " + count + " packages from Stack 1 to the floor.\n");

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; j < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }

                        System.out.print("\n\nGive " + name + " " + one.getVal(i).getWeight() + " lb package delivered on day " + one.getVal(i).getArrivalDate() + ".\n");
                        one.pop();
                        System.out.print("Return " + count + " packages to Stack 1 from the floor.\n");

                        for(int j = 0; j < count; j++){
                            one.push(floor.pop());
                        }

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; i < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }
                        break;
                    }
                }
                if(found){
                    continue;
                }
                int twoSize = two.getSize() - 1;
                for(int i = twoSize; i >= 0; i--){
                    if(two.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = two.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            floor.pushFloor(two.pop());
                        }
                        System.out.print("\nMove " + count + " packages from Stack 2 to the floor.\n");

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; j < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }

                        System.out.print("\n\nGive " + name + " " + two.getVal(i).getWeight() + " lb package delivered on day " + two.getVal(i).getArrivalDate() + ".\n");
                        two.pop();
                        System.out.print("Return " + count + " packages to Stack 2 from the floor.\n");

                        for(int j = 0; j < count; j++){
                            two.push(floor.pop());
                        }

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; i < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }
                        break;
                    }
                }

                if(found){
                    continue;
                }
                int threeSize = three.getSize() - 1;
                for(int i = threeSize; i >= 0; i--){
                    if(three.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = three.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            floor.pushFloor(three.pop());
                        }
                        System.out.print("\nMove " + count + " packages from Stack 3 to the floor.\n");

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; j < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }

                        System.out.print("\n\nGive " + name + " " + three.getVal(i).getWeight() + " lb package delivered on day " + three.getVal(i).getArrivalDate() + ".\n");
                        three.pop();
                        System.out.print("Return " + count + " packages to Stack 3 from the floor.\n");

                        for(int j = 0; j < count; j++){
                            three.push(floor.pop());
                        }

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; i < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }
                        break;
                    }
                }
                if(found){
                    continue;
                }
                int fourSize = four.getSize() - 1;
                for(int i = fourSize; i >= 0; i--){
                    if(four.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = four.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            floor.pushFloor(four.pop());
                        }
                        System.out.print("\nMove " + count + " packages from Stack 4 to the floor.\n");

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; j < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }

                        System.out.print("\n\nGive " + name + " " + four.getVal(i).getWeight() + " lb package delivered on day " + four.getVal(i).getArrivalDate() + ".\n");
                        four.pop();
                        System.out.print("Return " + count + " packages to Stack 4 from the floor.\n");

                        for(int j = 0; j < count; j++){
                            four.push(floor.pop());
                        }

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; i < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }
                        break;
                    }
                }
                if(found){
                    continue;
                }
                int fiveSize = five.getSize() - 1;
                for(int i = fiveSize; i >= 0; i--){
                    if(five.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = five.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            floor.pushFloor(five.pop());
                        }
                        System.out.print("\nMove " + count + " packages from Stack 5 to the floor.\n");

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; j < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }

                        System.out.print("\n\nGive " + name + " " + five.getVal(i).getWeight() + " lb package delivered on day " + five.getVal(i).getArrivalDate() + ".\n");
                        five.pop();
                        System.out.print("Return " + count + " packages to Stack 5 from the floor.\n");

                        for(int j = 0; j < count; j++){
                            five.push(floor.pop());
                        }

                        System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                        System.out.print("Stack 1 (A-G):|");
                        if(one.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < one.getSize(); j++){
                            System.out.print("[" + one.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 2 (H-J):|");
                        if(two.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < two.getSize(); j++){
                            System.out.print("[" + two.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 3 (K-M):|");
                        if(three.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < three.getSize(); j++){
                            System.out.print("[" + three.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 4 (N-R):|");
                        if(four.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < four.getSize(); j++){
                            System.out.print("[" + four.getVal(j).toString() + "]");
                        }
                        System.out.print("\nStack 5 (S-Z):|");
                        if(five.getSize() == 0){
                            System.out.print("empty");
                        }
                        for(int j = 0; j < five.getSize(); j++){
                            System.out.print("[" + five.getVal(j).toString() + "]");
                        }
                        System.out.print("\nFloor:|");
                        if(floor.getSize() == 0){
                            System.out.print("empty");
                        }
                        for (int j = 0; i < floor.getSize(); j++) {
                            System.out.print("[" + floor.getVal(j).toString() + "]");
                        }
                        break;
                    }
                }
                if(found){
                    continue;
                }
                int floorSize = floor.getSize() - 1;
                for(int i = floorSize; i >= 0; i--){
                    if(floor.getVal(i).getRecipient().equals(name)){
                        found = true;
                        int count = floor.getSize() - (1 + i);
                        for(int j = 0; j < count; j++) {
                            rndm.pushFloor(floor.pop());
                        }

                        System.out.print("\nGive " + name + " " + floor.getVal(i).getWeight() + " lb package delivered on day " + floor.getVal(i).getArrivalDate() + ".\n");
                        floor.pop();

                        for(int j = 0; j < count; j++){
                            floor.push(rndm.pop());
                        }
                    }
                }
                if(!found){
                    System.out.print("\n" + name + " has no packages to pick up!\n");
                }

            }
            else if(choice.equals("T")){
                day++;
                boolean check = false;
                int count1 = 0;
                System.out.print("\nIt is now day " + day + ".");

                boolean occurences = true;
                while(occurences) {
                    occurences = false;
                    int oneSize = one.getSize();
                    for (int i = 0; i < oneSize; i++) {
                        if ((day - one.getVal(i).getArrivalDate()) >= 5) {
                            check = true;

                            int count = one.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(one.pop());
                            }
                            count1++;
                            one.pop();
                            for (int j = 0; j < count; j++) {
                                one.push(floor.pop());
                            }
                        }
                    }
                    for(int i = 0; i < oneSize;i++){
                        if ((day - one.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }


                occurences = true;
                while(occurences) {
                    occurences = false;
                    int twoSize = two.getSize();
                    for (int i = 0; i < twoSize; i++) {
                        if ((day - two.getVal(i).getArrivalDate()) >= 5) {
                            check = true;
                            int count = two.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(two.pop());
                            }
                            count1++;
                            two.pop();
                            for (int j = 0; j < count; j++) {
                                two.push(floor.pop());
                            }
                        }
                    }
                    for(int i = 0; i < twoSize;i++){
                        if ((day - two.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int threeSize = three.getSize();
                    for (int i = 0; i < threeSize; i++) {
                        if ((day - three.getVal(i).getArrivalDate()) >= 5) {
                            check = true;
                            int count = three.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(three.pop());
                            }
                            count1++;
                            three.pop();
                            for (int j = 0; j < count; j++) {
                                three.push(floor.pop());
                            }
                        }
                    }
                    for(int i = 0; i < threeSize;i++){
                        if ((day - three.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int fourSize = four.getSize();
                    for (int i = 0; i < fourSize; i++) {
                        if ((day - four.getVal(i).getArrivalDate()) >= 5) {
                            check = true;
                            int count = four.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(four.pop());
                            }
                            count1++;
                            four.pop();
                            for (int j = 0; j < count; j++) {
                                four.push(floor.pop());
                            }
                        }
                    }
                    for(int i = 0; i < fourSize;i++){
                        if ((day - four.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int fiveSize = five.getSize();
                    for (int i = 0; i < fiveSize; i++) {
                        if ((day - five.getVal(i).getArrivalDate()) >= 5) {
                            check = true;
                            int count = five.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(five.pop());
                            }
                            count1++;
                            five.pop();
                            for (int j = 0; j < count; j++) {
                                five.push(floor.pop());
                            }
                        }
                    }
                    for(int i = 0; i < fiveSize;i++){
                        if ((day - five.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int floorSize = floor.getSize();
                    for (int i = 0; i < floorSize; i++) {
                        if ((day - floor.getVal(i).getArrivalDate()) >= 5) {
                            check = true;
                            int count = floor.getSize() - (i + 1);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(floor.pop());
                            }
                            count1++;
                            floor.pop();
                            for (int j = 0; j < count; j++) {
                                floor.pushFloor(rndm.pop());
                            }
                        }
                    }
                    for(int i = 0; i < floorSize;i++){
                        if ((day - floor.getVal(i).getArrivalDate()) >= 5) {
                            occurences = true;
                        }
                    }
                }

                if(check){
                    System.out.print(" " + count1 + " Packages have been returned to sender.\n");
                }
            }
            else if(choice.equals("P")){
                System.out.print("\nCurrent Packages:" + "\n-----------------\n");
                System.out.print("Stack 1 (A-G):|");
                if(one.getSize() == 0){
                    System.out.print("empty");
                }
                for(int i = 0; i < one.getSize(); i++){
                    System.out.print("[" + one.getVal(i).toString() + "]");
                }
                System.out.print("\nStack 2 (H-J):|");
                if(two.getSize() == 0){
                    System.out.print("empty");
                }
                for(int i = 0; i < two.getSize(); i++){
                    System.out.print("[" + two.getVal(i).toString() + "]");
                }
                System.out.print("\nStack 3 (K-M):|");
                if(three.getSize() == 0){
                    System.out.print("empty");
                }
                for(int i = 0; i < three.getSize(); i++){
                    System.out.print("[" + three.getVal(i).toString() + "]");
                }
                System.out.print("\nStack 4 (N-R):|");
                if(four.getSize() == 0){
                    System.out.print("empty");
                }
                for(int i = 0; i < four.getSize(); i++){
                    System.out.print("[" + four.getVal(i).toString() + "]");
                }
                System.out.print("\nStack 5 (S-Z):|");
                if(five.getSize() == 0){
                    System.out.print("empty");
                }
                for(int i = 0; i < five.getSize(); i++){
                    System.out.print("[" + five.getVal(i).toString() + "]");
                }
                System.out.print("\nFloor:|");
                if(floor.getSize() == 0){
                    System.out.print("empty");
                }
                for (int i = 0; i < floor.getSize(); i++) {
                    System.out.print("[" + floor.getVal(i).toString() + "]");
                }

            }
            else if(choice.equals("M")){
                System.out.print("Please select the source stack (enter 0 for floor):");
                int source = Integer.parseInt(scan.nextLine());
                System.out.print("Please enter the destination stack:");
                int destination = Integer.parseInt(scan.nextLine());

                if(source == 0){
                    if(floor.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if(destination == 1){
                        if(!one.isFull()) {
                            one.push(floor.pop());
                        }
                        else if(!two.isFull()){
                            two.push(floor.pop());
                        }
                        else if(!three.isFull()){
                            three.push(floor.pop());
                        }
                        else if(!four.isFull()){
                            four.push(floor.pop());
                        }
                        else if(!five.isFull()){
                            five.push(floor.pop());
                        }
                        else{
                            System.out.print("\nEvery stack is full! The package will be left where it is.\n");
                        }
                    }
                    else if(destination == 2){
                        if(!two.isFull()) {
                            two.push(floor.pop());
                        }
                        else if(!one.isFull()){
                            one.push(floor.pop());
                        }
                        else if(!three.isFull()){
                            three.push(floor.pop());
                        }
                        else if(!four.isFull()){
                            four.push(floor.pop());
                        }
                        else if(!five.isFull()){
                            five.push(floor.pop());
                        }
                        else{
                            System.out.print("\nEvery stack is full! The package will be left where it is.\n");
                        }
                    }
                    else if(destination == 3){
                        if(!three.isFull()) {
                            three.push(floor.pop());
                        }
                        else if(!two.isFull()){
                            two.push(floor.pop());
                        }
                        else if(!four.isFull()){
                            four.push(floor.pop());
                        }
                        else if(!one.isFull()){
                            one.push(floor.pop());
                        }
                        else if(!five.isFull()){
                            five.push(floor.pop());
                        }
                        else{
                            System.out.print("\nEvery stack is full! The package will be left where it is.\n");
                        }
                    }
                    else if(destination == 4){
                        if(!four.isFull()) {
                            four.push(floor.pop());
                        }
                        else if(!three.isFull()){
                            three.push(floor.pop());
                        }
                        else if(!five.isFull()){
                            five.push(floor.pop());
                        }
                        else if(!two.isFull()){
                            two.push(floor.pop());
                        }
                        else if(!one.isFull()){
                            one.push(floor.pop());
                        }
                        else{
                            System.out.print("\nEvery stack is full! The package will be left where it is.\n");
                        }
                    }
                    else if(destination == 5){
                        if(!five.isFull()) {
                            five.push(floor.pop());
                        }
                        else if(!four.isFull()){
                            four.push(floor.pop());
                        }
                        else if(!three.isFull()){
                            three.push(floor.pop());
                        }
                        else if(!two.isFull()){
                            two.push(floor.pop());
                        }
                        else if(!one.isFull()){
                            one.push(floor.pop());
                        }
                        else{
                            System.out.print("\nEvery stack is full! The package will be left where it is.\n");
                        }
                    }
                    else{
                        System.out.print("\nThat is not a valid destination!\n");
                    }
                }

                else if(source == 1){
                    if(one.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if(destination == 0){
                        floor.pushFloor(one.pop());
                    } else if (destination == 1) {

                    } else if (destination == 2) {
                        if (!two.isFull()) {
                            two.push(one.pop());
                        } else if (!one.isFull()) {

                        }
                    } else if (destination == 3) {
                        if (!three.isFull()) {
                            three.push(one.pop());
                        } else if (!two.isFull()) {
                            two.push(one.pop());
                        } else if (!four.isFull()) {
                            four.push(one.pop());
                        } else if (!one.isFull()) {

                        }
                    } else if (destination == 4) {
                        if (!four.isFull()) {
                            four.push(one.pop());
                        } else if (!three.isFull()) {
                            three.push(one.pop());
                        } else if (!five.isFull()) {
                            five.push(one.pop());
                        } else if (!two.isFull()) {
                            two.push(one.pop());
                        } else if (!one.isFull()) {

                        }
                    } else if (destination == 5) {
                        if (!five.isFull()) {
                            five.push(one.pop());
                        } else if (!four.isFull()) {
                            four.push(one.pop());
                        } else if (!three.isFull()) {
                            three.push(one.pop());
                        } else if (!two.isFull()) {
                            two.push(one.pop());
                        } else if (!one.isFull()) {

                        }
                    } else {
                        System.out.print("\nThat is not a valid destination!\n");
                    }
                }

                else if(source == 2){
                    if(two.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if(destination == 0){
                        floor.pushFloor(two.pop());
                    }
                    else if (destination == 1) {
                        if (!one.isFull()) {
                            one.push(two.pop());
                        }
                        else if(!two.isFull()){

                        }
                    } else if (destination == 2) {

                    } else if (destination == 3) {
                        if (!three.isFull()) {
                            three.push(two.pop());
                        } else if (!two.isFull()) {

                        }
                    } else if (destination == 4) {
                        if (!four.isFull()) {
                            four.push(two.pop());
                        } else if (!three.isFull()) {
                            three.push(two.pop());
                        } else if (!five.isFull()) {
                            five.push(two.pop());
                        } else if (!two.isFull()) {

                        }
                    } else if (destination == 5) {
                        if (!five.isFull()) {
                            five.push(two.pop());
                        } else if (!four.isFull()) {
                            four.push(two.pop());
                        } else if (!three.isFull()) {
                            three.push(two.pop());
                        } else if (!two.isFull()) {

                        }
                    } else {
                        System.out.print("\nThat is not a valid destination!\n");
                    }
                }

                else if(source == 3) {
                    if(three.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if (destination == 0) {
                        floor.pushFloor(three.pop());
                    }
                    else if (destination == 1) {
                        if (!one.isFull()) {
                            one.push(three.pop());
                        } else if (!two.isFull()) {
                            two.push(three.pop());
                        } else if (!three.isFull()) {

                        }
                    } else if (destination == 2) {
                        if (!two.isFull()) {
                            two.push(three.pop());
                        } else if (!one.isFull()) {
                            one.push(three.pop());
                        } else if (!three.isFull()) {

                        }
                    } else if (destination == 3) {

                    } else if (destination == 4) {
                        if (!four.isFull()) {
                            four.push(three.pop());
                        } else if (!three.isFull()) {

                        }
                    } else if (destination == 5) {
                        if (!five.isFull()) {
                            five.push(three.pop());
                        } else if (!four.isFull()) {
                            four.push(three.pop());
                        } else if (!three.isFull()) {

                        }
                    } else {
                        System.out.print("\nThat is not a valid destination!\n");
                    }
                }

                else if(source == 4) {
                    if(four.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if (destination == 0) {
                        floor.pushFloor(four.pop());
                    }
                    else if (destination == 1) {
                        if (!one.isFull()) {
                            one.push(four.pop());
                        } else if (!two.isFull()) {
                            two.push(four.pop());
                        } else if (!three.isFull()) {
                            three.push(four.pop());
                        } else if (!four.isFull()) {

                        }
                    } else if (destination == 2) {
                        if (!two.isFull()) {
                            two.push(four.pop());
                        } else if (!one.isFull()) {
                            one.push(four.pop());
                        } else if (!three.isFull()) {
                            three.push(four.pop());
                        } else if (!four.isFull()) {

                        }
                    } else if (destination == 3) {
                        if (!three.isFull()) {
                            three.push(four.pop());
                        } else if (!two.isFull()) {
                            two.push(four.pop());
                        } else if (!four.isFull()) {

                        }
                    } else if (destination == 4) {

                    } else if (destination == 5) {
                        if (!five.isFull()) {
                            five.push(four.pop());
                        } else if (!four.isFull()) {

                        }
                    }
                }

                else if(source == 5){
                    if(five.isEmpty()){
                        System.out.print("\nThe stack is empty!\n");
                        continue;
                    }
                    if(destination == 0){
                        floor.pushFloor(five.pop());
                    }
                    else if(destination == 1){
                        if(!one.isFull()) {
                            one.push(five.pop());
                        }
                        else if(!two.isFull()){
                            two.push(five.pop());
                        }
                        else if(!three.isFull()){
                            three.push(five.pop());
                        }
                        else if(!four.isFull()){
                            four.push(five.pop());
                        }
                        else if(!five.isFull()){

                        }
                    }
                    else if(destination == 2){
                        if(!two.isFull()) {
                            two.push(five.pop());
                        }
                        else if(!one.isFull()){
                            one.push(five.pop());
                        }
                        else if(!three.isFull()){
                            three.push(five.pop());
                        }
                        else if(!four.isFull()){
                            four.push(five.pop());
                        }
                        else if(!five.isFull()){

                        }
                    }
                    else if(destination == 3){
                        if(!three.isFull()) {
                            three.push(five.pop());
                        }
                        else if(!two.isFull()){
                            two.push(five.pop());
                        }
                        else if(!four.isFull()){
                            four.push(five.pop());
                        }
                        else if(!one.isFull()){
                            one.push(five.pop());
                        }
                        else if(!five.isFull()){

                        }
                    }
                    else if(destination == 4){
                        if(!four.isFull()) {
                            four.push(five.pop());
                        }
                        else if(!three.isFull()){
                            three.push(five.pop());
                        }
                        else if(!five.isFull()){

                        }
                    }
                    else if(destination == 5){

                    }
                    else{
                        System.out.print("\nThat is not a valid destination!\n");
                    }
                }
                else{
                    System.out.print("\nThat is not a valid source!\n");
                }


            }
            else if(choice.equals("F")){
                boolean check = false;
                boolean occurences = true;

                while(occurences) {
                    occurences = false;
                    int oneSize = one.getSize();
                    for (int i = 0; i < oneSize; i++) {
                        if (!(one.getVal(i).getRecipient().toUpperCase().charAt(0) >= 65 && one.getVal(i).getRecipient().toUpperCase().charAt(0) <= 71)) {
                            check = true;
                            int count = one.getSize() - (1 + i);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(one.pop());
                            }
                            floor.pushFloor(one.pop());
                            for (int j = 0; j < count; j++) {
                                one.push(rndm.pop());
                            }
                        }
                    }
                    for (int i = 0; i < oneSize; i++) {
                        if (!(one.getVal(i).getRecipient().toUpperCase().charAt(0) >= 65 && one.getVal(i).getRecipient().toUpperCase().charAt(0) <= 71)) {
                            occurences = true;
                            continue;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int twoSize = two.getSize();
                    for (int i = 0; i < twoSize; i++) {
                        if (!(two.getVal(i).getRecipient().toUpperCase().charAt(0) >= 72 && two.getVal(i).getRecipient().toUpperCase().charAt(0) <= 74)) {
                            check = true;
                            int count = two.getSize() - (1 + i);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(two.pop());
                            }
                            floor.pushFloor(two.pop());
                            for (int j = 0; j < count; j++) {
                                two.push(rndm.pop());
                            }
                        }
                    }
                    for (int i = 0; i < twoSize; i++) {
                        if (!(two.getVal(i).getRecipient().toUpperCase().charAt(0) >= 72 && two.getVal(i).getRecipient().toUpperCase().charAt(0) <= 74)) {
                            occurences = true;
                            continue;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int threeSize = three.getSize();
                    for (int i = 0; i < threeSize; i++) {
                        if (!(three.getVal(i).getRecipient().toUpperCase().charAt(0) >= 75 && three.getVal(i).getRecipient().toUpperCase().charAt(0) <= 77)) {
                            check = true;
                            int count = three.getSize() - (1 + i);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(three.pop());
                            }
                            floor.pushFloor(three.pop());
                            for (int j = 0; j < count; j++) {
                                three.push(rndm.pop());
                            }
                        }
                    }
                    for (int i = 0; i < threeSize; i++) {
                        if (!(three.getVal(i).getRecipient().toUpperCase().charAt(0) >= 75 && three.getVal(i).getRecipient().toUpperCase().charAt(0) <= 77)) {
                            occurences = true;
                            continue;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int fourSize = four.getSize();
                    for (int i = 0; i < fourSize; i++) {
                        if (!(four.getVal(i).getRecipient().toUpperCase().charAt(0) >= 78 && four.getVal(i).getRecipient().toUpperCase().charAt(0) <= 82)) {
                            check = true;
                            int count = four.getSize() - (1 + i);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(four.pop());
                            }
                            floor.pushFloor(four.pop());
                            for (int j = 0; j < count; j++) {
                                four.push(rndm.pop());
                            }
                        }
                    }
                    for (int i = 0; i < fourSize; i++) {
                        if (!(four.getVal(i).getRecipient().toUpperCase().charAt(0) >= 78 && four.getVal(i).getRecipient().toUpperCase().charAt(0) <= 82)) {
                            occurences = true;
                            continue;
                        }
                    }
                }

                occurences = true;
                while(occurences) {
                    occurences = false;
                    int fiveSize = five.getSize();
                    for (int i = 0; i < fiveSize; i++) {
                        if (!(five.getVal(i).getRecipient().toUpperCase().charAt(0) >= 83 && five.getVal(i).getRecipient().toUpperCase().charAt(0) <= 90)) {
                            check = true;
                            int count = five.getSize() - (1 + i);
                            for (int j = 0; j < count; j++) {
                                rndm.pushFloor(five.pop());
                            }
                            floor.pushFloor(five.pop());
                            for (int j = 0; j < count; j++) {
                                five.push(rndm.pop());
                            }
                        }
                    }
                    for (int i = 0; i < fiveSize; i++) {
                        if (!(five.getVal(i).getRecipient().toUpperCase().charAt(0) >= 83 && five.getVal(i).getRecipient().toUpperCase().charAt(0) <= 90)) {
                            occurences = true;
                            continue;
                        }
                    }
                }


                if(check){
                    System.out.print("\nMisplaced packages moved to floor!\n");
                }
            }
            else if(choice.equals("L")) {
                System.out.print("Please enter a recipient name:");
                String name = scan.nextLine();
                int count = 0;
                for (int i = 0; i < one.getSize(); i++) {
                    if (one.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }
                for (int i = 0; i < two.getSize(); i++) {
                    if (two.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }
                for (int i = 0; i < three.getSize(); i++) {
                    if (three.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }
                for (int i = 0; i < four.getSize(); i++) {
                    if (four.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }
                for (int i = 0; i < five.getSize(); i++) {
                    if (five.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }
                for (int i = 0; i < floor.getSize(); i++) {
                    if (floor.getVal(i).getRecipient().equals(name)) {
                        count++;
                    }
                }

                System.out.print("\n" + name + " has " + count + " packages total.\n");

                int count1 = 0;
                for (int i = 0; i < one.getSize(); i++) {
                    if (one.getVal(i).getRecipient().equals(name)) {
                            count1++;
                            System.out.println("Package " + count1 + " is in Stack 1, it was delivered on day " +
                                    "" + one.getVal(i).getArrivalDate() + ", and weighs " + one.getVal(i).getWeight() + " lbs.");
                    }
                }
                for (int i = 0; i < two.getSize(); i++) {
                    if (two.getVal(i).getRecipient().equals(name)) {
                        count1++;
                        System.out.println("Package " + count1 + " is in Stack 2, it was delivered on day " +
                                "" + two.getVal(i).getArrivalDate() + ", and weighs " + two.getVal(i).getWeight() + " lbs.");
                    }
                }
                for (int i = 0; i < three.getSize(); i++) {
                    if (three.getVal(i).getRecipient().equals(name)) {
                        count1++;
                        System.out.println("Package " + count1 + " is in Stack 3, it was delivered on day " +
                                "" + three.getVal(i).getArrivalDate() + ", and weighs " + three.getVal(i).getWeight() + " lbs.");
                    }
                }
                for (int i = 0; i < four.getSize(); i++) {
                    if (four.getVal(i).getRecipient().equals(name)) {
                        count1++;
                        System.out.println("Package " + count1 + " is in Stack 4, it was delivered on day " +
                                "" + four.getVal(i).getArrivalDate() + ", and weighs " + four.getVal(i).getWeight() + " lbs.");
                    }
                }
                for (int i = 0; i < five.getSize(); i++) {
                    if (five.getVal(i).getRecipient().equals(name)) {
                        count1++;
                        System.out.println("Package " + count1 + " is in Stack 5, it was delivered on day " +
                                "" + five.getVal(i).getArrivalDate() + ", and weighs " + five.getVal(i).getWeight() + " lbs.");
                    }
                }
                for (int i = 0; i < floor.getSize(); i++) {
                    if (floor.getVal(i).getRecipient().equals(name)) {
                        count1++;
                        System.out.println("Package " + count1 + " is on the floor, it was delivered on day " +
                                "" + floor.getVal(i).getArrivalDate() + ", and weighs " + floor.getVal(i).getWeight() + " lbs.");
                    }
                }
            }
            else if(choice.equals("E")){
                int floorSize = floor.getSize();
                for(int i = 0; i < floorSize;i++){
                    floor.pop();
                }
                System.out.print("\nThe floor has been emptied. Mr. Trash can is no longer hungry!\n");
            }
            else if(choice.equals("Q")){

            }
            else{
                System.out.print("\nThat is not a valid choice!\n");
            }
        }

        System.out.print("\nUse Amazon Locker next time!\n");
        scan.close();
    }
}
