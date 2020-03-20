package com.DAA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobSequencingProblem {

    static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        @Override
        public int compareTo(Job otherJob) {
            return otherJob.profit - this.profit;
        }

        public Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        JobSequencingProblem jobSequencing = new JobSequencingProblem();
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job('a', 2, 100));
        jobs.add(new Job('b', 1, 19));
        jobs.add(new Job('c', 2, 27));
        jobs.add(new Job('d', 1, 25));
        jobs.add(new Job('e', 3, 15));

        Collections.sort(jobs);


        for (Job job : jobs) {
            System.out.println(job.id + " - " + job.profit);
        }
        jobSequencing.printJobSequence(jobs, jobs.size());

    }

    private void printJobSequence(ArrayList<Job> jobs, int size) {
        Boolean[] slots;
        slots = new Boolean[size];
        Arrays.fill(slots, false);

        int[] result = new int[size];

        {
            int i = 0;
            while (i < size) {
                int j = jobs.get(i).deadline - 1;
                while (j >= 0) {
                    if (!slots[j]) {
                        result[j] = i;
                        slots[j] = true;
                        break;
                    }
                    j--;
                }
                i++;
            }
        }

        int i = 0;
        while (i < jobs.size()) {
            if (slots[i])
                System.out.print(jobs.get(result[i]).id + " -> ");
            i++;
        }
    }
}
