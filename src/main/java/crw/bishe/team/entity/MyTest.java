package crw.bishe.team.entity;

import javax.persistence.*;

@Table(name = "my_test")
public class MyTest {
    @Id
    @Column(name = "test_id")
    private Long testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_mark")
    private String testMark;

    /**
     * @return test_id
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * @param testId
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * @return test_name
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName
     */
    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    /**
     * @return test_mark
     */
    public String getTestMark() {
        return testMark;
    }

    /**
     * @param testMark
     */
    public void setTestMark(String testMark) {
        this.testMark = testMark == null ? null : testMark.trim();
    }
}