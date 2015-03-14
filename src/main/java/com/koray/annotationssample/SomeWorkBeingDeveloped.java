package com.koray.annotationssample;

@Reviewable
public class SomeWorkBeingDeveloped {
    public SomeWorkBeingDeveloped() {
        super();
    }

    
    @ReviewStatus(author = "FATMA" , status = ReviewStatus.Status.DEVELOPMENT_IN_PROGRESS  )
    public void doSomeWork() {
        // No Code Written yet
    }


    @ReviewStatus(author = "HAMZA" , status = ReviewStatus.Status.TO_BE_REVIEWED , reviewer = "FATMA" )
    public void doSomeMoreWork() {
       //the purpose of this method is to print something
       System.out.println("hello world!");
    }


}
