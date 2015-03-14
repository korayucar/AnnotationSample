package com.koray.annotationssample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface ReviewStatus {

    public enum Status {DEVELOPMENT_IN_PROGRESS, TO_BE_REVIEWED , REVIEW_STARTED, REVIEW_PASSED , REVIEW_FAILED}
    String author() default "Unknown";
    String reviewer() default "To be assigned";

    Status status() default Status.DEVELOPMENT_IN_PROGRESS;
}
