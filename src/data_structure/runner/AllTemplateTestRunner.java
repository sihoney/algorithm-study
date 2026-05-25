package data_structure.runner;

public class AllTemplateTestRunner {
    public static void main(String[] args) {
        FunctionalTestRunner.main(args);
        CoreImplementedTestRunner.main(args);
        CorePendingImplementationTestRunner.main(args);
        System.out.println("ALL TEMPLATE TESTS PASSED");
    }
}
