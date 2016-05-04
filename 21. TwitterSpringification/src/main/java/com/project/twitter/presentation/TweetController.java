package com.project.twitter.presentation;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.twitter.domain.Tweet;
import com.project.twitter.service.Service;

@Component
public class TweetController implements Controller{

	private Service tweetService;
	private Scanner in = new Scanner(System.in);

	@Autowired
	public TweetController(Service tweetService) {
		this.tweetService = tweetService;
	}

	@Override
	public void run(){
		String command;
		boolean proceed = true;

		while (proceed) {

			showMainMenu();
			command = in.nextLine();

			switch (command) {
			case "1":
				tweetMessage();
				break;

			case "2":
				listMessages();
				break;

			case "3":
				deleteTweet();
				break;

			case "exit":
				proceed = false;
				in.close();
				break;

			default:
				break;
			}
		}
	}
	
	public void showMainMenu() {

		System.out.println("Enter: ");
		System.out.println("1 for Tweet a message ");
		System.out.println("2 for listing Messages ");
		System.out.println("3 for delete Tweet");
		System.out.println("4 Enter 'exit' for logout ");
	}

	public void tweetMessage(){
		
		System.out.println("Enter username and message: ");
		
		String username = in.nextLine();
		String message = in.nextLine();
		
		try{
			tweetService.tweetMessage(username, message);
			System.out.println("Successfully saved tweet");
		}catch(RuntimeException e){
			System.out.println("Faliure saving tweet");
			System.out.println(e.getMessage());
		}
	}
	
	public void listMessages() {

		System.out.println("All tweets are: ");

		try {
			List<Tweet> tweets = tweetService.listMessages();
			for (Tweet tweet : tweets){
				System.out.println(tweet);
			}
		} catch (RuntimeException e) {
			System.out.println("Faliure listing tweets");
			System.out.println(e.getMessage());
		}
	}

	public void deleteTweet(){
			System.out.println("Insert id of the tweet to delete");
			
			try {
				Long id = (Long.parseLong(in.nextLine()));
				tweetService.deleteTweet(id);
				System.out.println("Successfully deleted Tweet");
			}catch(NumberFormatException e){
				System.out.println("Incorrect input format");
				System.out.println(e.getMessage());
			}catch (RuntimeException e) {
				System.out.println("Failure deleting Tweet");
				System.out.println(e.getMessage());
			}
		}
}
