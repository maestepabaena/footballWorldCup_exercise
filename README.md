# TDD exercise - Football World Cup Score Board

Instructions
Please provide the implementation of the Football World Cup Score Board as a simple library. Guidelines 
- Keep it simple. Stick to the requirements and try to implement the simplest solution you can possibly think of that works.
- Use an in-memory store solution (for example just use collections to store the information you might require).
- We are NOT looking for a REST API, a Web Service or Microservice. Just a simple implementation.
- Focus on Quality. Use Test-Driven Development (TDD), pay attention to OO design, Clean Code and adherence to SOLID principles.
- Approach. Code the solution according to your standards. Please share your solution with a link to a source control repository (e.g. GitHub, GitLab, BitBucket) as we would like you to see your progress (your commit history is important)
- Add a README.md file where you can make notes of any assumption or things you would like to mention to us about your solution.

#Football World Cup Score Board. Implementation Details 
You are working on a sports data company, and we would like you to develop a new Live Football World Cup Score Board that shows matches and scores.
The board supports the following operations:
1. Start a game. Our data partners will send us data for the games when they start, and these should capture (Initial score is 0 – 0).
   a. Home team
   b. Away team
2. Finish game. It will remove a match from the scoreboard.
3. Update score. Receiving the pair score; home team score and away team score updates a game score.
4. Get a summary of games by total score. Those games with the same total score will be returned ordered by the most recently added to our system.
   As an example, being the current data in the system:
   a. Mexico - Canada: 0 - 5
   b. Spain - Brazil: 10 – 2
   c. Germany - France: 2 – 2
   d. Uruguay - Italy: 6 – 6
   e. Argentina - Australia: 3 - 1
   The summary would provide with the following information:
5. Uruguay 6 - Italy 6
6. Spain 10 - Brazil 2
7. Mexico 0 - Canada 5
8. Argentina 3 - Australia 1
9. Germany 2 - France 2

Notes

This exercise was done trying to follow TDD basic pattern and workflow of refactoring (Martin Fowler)
