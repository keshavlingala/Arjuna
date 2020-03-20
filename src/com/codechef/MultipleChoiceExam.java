package com.codechef;

/*All submissions for this problem are available.### Read problems statements in Hindi, Mandarin Chinese, Russian, Vietnamese, and Bengali as well.

Chef is taking a cooking exam. The exam consists of NN multiple-choice questions numbered 11 through NN. In each question, Chef may choose one out of four choices: A, B, C and D, or leave the question unanswered.

Answering a question correctly gives Chef 11 point. Not answering a question or answering it incorrectly gives him 00 points. However, there is a penalty for wrong answers. Specifically, the questions are graded one by one from question 11 to question NN; for each ii (1≤i≤N−11≤i≤N−1), if Chef answered the ii-th question incorrectly, his answer to the next question (the (i+1)(i+1)-th question) is discarded without being graded. If an answer is discarded, Chef gets 00 points for it automatically, but even if it was wrong, the next answer is not discarded. There is no penalty for answering the last question incorrectly or for not answering some questions.

You are given the correct answers to all NN questions and Chef's answers. Calculate the total number of points Chef scored on the exam.

Input
The first line of the input contains a single integer TT denoting the number of test cases. The description of TT test cases follows.
The first line of each test case contains a single integer NN.
The second line contains a single string SS with length NN. For each valid ii, the ii-th character of this string denotes the correct answer to the ii-th question.
The third line contains a single string UU with length NN. For each valid ii, the ii-th character of this string is 'N' if Chef did not answer the ii-th question; otherwise, it denotes Chef's answer to this question.
Output
For each test case, print a single line containing one integer — Chef's score.

Constraints
1≤T≤1001≤T≤100
1≤N≤1001≤N≤100
SS contains only characters 'A', 'B', 'C', 'D'
UU contains only characters 'A', 'B', 'C', 'D', 'N'
Example Input
3
6
ABCDAB
ABCDAB
8
DDCABCCA
DNCBBBBA
3
CDD
NDC
Example Output
6
3
1
Explanation
Example case 1: Chef's answers were all correct, so he got a full score.

Example case 2: Chef did not answer question 22 and he answered questions 44 and 66 incorrectly, which resulted in discarding answers to questions 55 and 77. Note that even though Chef's answer to question 77 was wrong, it was discarded, so it did not result in discarding his answer to question 88.

Example case 3: Chef did not answer the first question and he answered the last question incorrectly, but there is no penalty for that.*/

public class MultipleChoiceExam {
    public static void main(String[] args) {

    }
}
