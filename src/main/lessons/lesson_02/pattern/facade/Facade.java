package ru.gb.lessons.lesson_02.pattern.facade;

/**
 * Реализация фасада
 */
public class Facade implements IFacade{

    private ExampleClass exampleClass = new ExampleClass();

    @Override
    public void runAlgorithmSimple() {
        exampleClass.step1();
        exampleClass.step6();
    }

    @Override
    public void runAlgorithmFull() {
        exampleClass.step1();
        exampleClass.step2();
        exampleClass.step3();
        exampleClass.step4();
        exampleClass.step5();
        exampleClass.step6();
    }

    @Override
    public int countSteps() {
        return exampleClass.count;
    }


}
