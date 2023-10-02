package ru.sber.niva;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

import java.net.URI;

public class Main {
    public static void main(String[] args) {

        JiraRestClient jiraRestClient = new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create("localhost:5555"), "user", "pass");

        var issueClient = jiraRestClient.getIssueClient();
        var issue = issueClient.getIssue("1");
    }
}