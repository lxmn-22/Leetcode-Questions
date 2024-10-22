/*
You have n processors each having 4 cores and n * 4 tasks that need to be executed 
such that each core should perform only one task.

Given a 0-indexed integer array processorTime representing the time at which each processor becomes 
available for the first time and a 0-indexed integer array tasks representing the time it takes to 
execute each task, return the minimum time when all of the tasks have been executed by the processors.

Note: Each core executes the task independently of the others.
Constraints:
1 <= n == processorTime.length <= 25000
1 <= tasks.length <= 105
0 <= processorTime[i] <= 109
1 <= tasks[i] <= 109
tasks.length == 4 * n
*/
class MinimumProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>();
        PriorityQueue<Integer> processorQueue = new PriorityQueue<>((a, b) -> b - a);
        taskQueue.addAll(tasks);
        processorQueue.addAll(processorTime);
        int totalTime = Integer.MIN_VALUE;
        while (!processorQueue.isEmpty()) {
            int startTime = processorQueue.remove();
            int currentTime = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                currentTime = Math.max(currentTime, startTime + taskQueue.remove());
            }
            totalTime = Math.max(totalTime, currentTime);
        }
        return totalTime;
    }
}