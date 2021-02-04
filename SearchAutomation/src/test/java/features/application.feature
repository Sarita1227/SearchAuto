Feature: Application functionality test  
	
Scenario Outline: User can search desired job post 
	Given User is in application home page and verify application header <HomePage>
	Then Enter job title name <Job Title> and Job Location <Job Location> and Distance <Distance> 
	Then Click on More Option button and verify the section is displayed 
	Then Enter Min Salary <MinSal> and Max Salary <MaxSal> and Salary Type <SalType> and Job Type <JobType>
	Then Click on Find job button and verify the Job Search Header <ResultHeader>
	Then User navigate back to the home page and verify home page is displayed <HomePage>
	
	Examples: 
		| Job Title  | Job Location | Distance     | MinSal  | MaxSal  | SalType   | JobType   | ResultHeader 						  | HomePage 				 |
		| QA Engineer| London		| up to 2 miles | 40000	 | 50000   | Per annum | Permanent | Permanent Qa Engineer jobs in London | Search jobs in your area |
		| SDET		 | Reading 		| up to 5 miles | 35000	 | 40000   | Per week  | Contract  | Contract Sdet jobs in Reading 		  | Search jobs in your area |
	