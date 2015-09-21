package com.telis.patreopolis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PatreopolisDemoMVC {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("patreopolisPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        

        
//        Question model = new Question(rand.nextInt(18) + 1);
//        Question model = new Question();
//        Question model1 = new Question();
//        Question model2 = new Question();
        Question[] model = new Question[52];
//         for (int i = 0; i < 19; i++) {
//             model[i] = new Question(i+1);
//         }
//         entityManager.persist(model);
//        final Random rand = new Random();
        for (int i = 1; i < 53; i++) {
//                model = entityManager.getReference(model.getClass(), rand.nextInt(19) + 1);//2 equals with primary key. primary key is actually the questionID
//                model1 = entityManager.find(Question.class, 1);
//                model2 = entityManager.find(Question.class, 2);
                model[i-1] = entityManager.find(Question.class, i);
//                model[1] = entityManager.find(Question.class, 2);
//                model[2] = entityManager.find(Question.class, 3);
////                List<Question> myQuestions = new ArrayList<Question>();
//                myQuestions.add(model1);
//                myQuestions.add(model2);
            }
                
//        System.out.println("User name retrieved is: " + model.getAnswer1());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        
        
        
        
//        PlayerController newGame = new PlayerController(myQuestions);
        PlayerController newGame = new PlayerController(model);
        newGame.run();


    }
}

//    private static void retrieveQuestionFromStack() {
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("In which street we meet the archaeological museum of Patras?");
//        list.add("Korinthou-Athinon National Road");
//        list.add("Corinthou Street");
//        list.add("Mezonos Street");
//        list.add("Germanou Street");




//    }


