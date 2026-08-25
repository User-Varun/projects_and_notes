/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.varun.practicingwritinginjava;

/**
 *
 * @author Varun
 */
class Parent {

    private String birthInfo; // day-month-year

    Parent(String bi) {
        this.birthInfo = bi;
    }

    private double[] processBirthInfo(String birthInfo) {
        String[] split = birthInfo.split("-");

        double[] nums = new double[split.length];

        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        return nums;

    }

    ;
    
    public String getAge() {
        double[] age = processBirthInfo(birthInfo);
        
        return "Day " + age[0] + " Month " + age[1] + " Year " + age[2];
    };
    
}
