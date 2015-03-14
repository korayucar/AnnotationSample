package com.koray.annotationssample;

import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Koray Ucar (kryucar@gmail.com)
 */

public class ReviewReport {
    public ReviewReport() {
        super();
    }

    public static void main(String[] args) {
        getReviewReport();
        getReviewWorkForPerson("FATMA");
    }


    private static void getReviewReport() {
        Reflections reflections = new Reflections("com.koray.annotationssample");
        Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(Reviewable.class);


        for (Class work : allClasses) {
            for (Method method : work.getMethods()) {
                ReviewStatus annotation = (ReviewStatus) method.getAnnotation(ReviewStatus.class);
                if (annotation != null) {
                    System.out.println("\n\n Method Name : " + method.getName());
                    System.out.println(" Author : " + annotation.author());
                    System.out.println(" Reviewer : " + annotation.reviewer());
                    System.out.println(" Status : " + annotation.status());
                }
            }
        }
    }

    private static void getReviewWorkForPerson(String person) {
        Reflections reflections = new Reflections("com.koray.annotationssample");
        Set<Class<? extends Object>> allClasses = reflections.getTypesAnnotatedWith(Reviewable.class);


        for (Class work : allClasses) {
            for (Method method : work.getMethods()) {
                ReviewStatus annotation = (ReviewStatus) method.getAnnotation(ReviewStatus.class);
                if (annotation != null && annotation.status() == ReviewStatus.Status.TO_BE_REVIEWED && annotation.reviewer().equals(person)) {
                    System.out.println("\n\n Method Name : " + method.getName());
                    System.out.println(" Author : " + annotation.author());
                    System.out.println(" Reviewer : " + annotation.reviewer());
                    System.out.println(" Status : " + annotation.status());
                }
            }
        }
    }

}
