package model;

public class Poll {

	private String question1;
	private String question2;
	private String question3;
	private int answer1;
	private int answer2;
	private int answer3;

	public Poll(int answer1,int answer2, int answer3) {

		this.question1 = "1.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the service provided";
		this.question2 = "2.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the response time given";
		this.question3 = "3.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the cost / benefit ratio of the service purchased";
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public int getAnswer1() {
		return answer1;
	}

	public void setAnswer1(int answer1) {
		this.answer1 = answer1;
	}

	public int getAnswer2() {
		return answer2;
	}

	public void setAnswer2(int answer2) {
		this.answer2 = answer2;
	}

	public int getAnswer3() {
		return answer3;
	}

	public void setAnswer3(int answer3) {
		this.answer3 = answer3;
	}


}
