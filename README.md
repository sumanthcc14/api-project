# api-project
# Voting App

 Usage Guide

1. Run the Application:
    - Execute mvn spring-boot:run to start the Spring Boot application.

2. API Endpoints:
   - Enter Candidate: http://localhost:8080/entercandidate?name={candidateName}
   - Cast Vote: http://localhost:8080/castvote?name={candidateName}
   - Count Vote: http://localhost:8080/countvote?name={candidateName}
   - List Votes: http://localhost:8080/listvote
   - Get Winner: http://localhost:8080/getwinner

3. Features Implemented:
   - Candidate entry with vote count initialization.
   - Casting votes for valid candidates.
   - Counting and displaying the latest vote count for a candidate.
   - Listing all candidates with their respective vote counts in JSON format.
   - Determining the winner based on the highest number of votes.

4. Unit Testing:
   - Unit tests implemented using JUnit and Mockito for API endpoints.


