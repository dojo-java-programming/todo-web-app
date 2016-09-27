Feature: To do list
	As a user I want to create new todo-entries. I want to show all todo's on my list.
	And I want to remove todo-entries.

@tag1
Scenario: Add new todo entry
Given I have an empty todo list
When I add a todo with id 1 and title "Write some BDD tests"
Then I expect a todo list with 1 entry


#@tag2
#Scenario Outline: Title of your scenario outline
#Given I want to write a step with <name>
#When I check for the <value> in step
#Then I verify the <status> in step
#
#Examples:
    #| name  |value | status |
    #| name1 |  5   | success|
    #| name2 |  7   | Fail   |
