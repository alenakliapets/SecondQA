package TestsLesson14.HomeWork.Testrail.Builder;

public class TestCaseBuilder {
    String title;
    String section;
    String template;
    String type;
    String priority;

    public static class Builder {
        private TestCaseBuilder testCaseBuilder;

        public Builder(){
            testCaseBuilder = new TestCaseBuilder();
        }
        public Builder withTitle(String title){
            testCaseBuilder.title = title;
            return this;
        }

        public Builder withSection(String section){
            testCaseBuilder.section = section;
            return this;
        }

        public Builder withTemplate (String template){
            testCaseBuilder.template = template;
            return this;
        }
        public Builder withType (String type){
            testCaseBuilder.type = type;
            return this;
        }
        public Builder withPriority (String priority){
            testCaseBuilder.priority = priority;
            return this;
        }
        public TestCaseBuilder build(){
            return testCaseBuilder;
        }

    }

}
