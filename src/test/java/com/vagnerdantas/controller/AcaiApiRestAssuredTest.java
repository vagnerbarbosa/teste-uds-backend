package com.vagnerdantas.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.vagnerdantas.enumeration.MessageEnum;
import com.vagnerdantas.util.MessageUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Copyright @author Vagner Dantas
 */
public class AcaiApiRestAssuredTest {

    WireMockServer wireMockServer;

    @BeforeEach
    public void setup () {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
    }

    @AfterEach
    public void teardown () {
        wireMockServer.stop();
    }

    @Test
    public void eventsPersistSuccessfully() {
        given().
                header("content-type", "application/json").
                when().
                body(WEBHOOK_JSON).
                when().
                post("/events").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void eventsPersistNoContent() {
        given().
                header("content-type", "application/json").
                when().
                body("{}").
                when().
                post("/events").
                then().
                assertThat().
                statusCode(500);
    }

    @Test
    public void eventsPersistUnsupportedMediaType() {
        given().
                when().
                post("/events").
                then().
                body("message", equalTo("Content type 'application/x-www-form-urlencoded;charset=ISO-8859-1' not supported")).
                assertThat().
                statusCode(415);
    }

    @Test
    public void getAllInvalidNumber() {
        given().
                when().
                get("/issues/XYZ/events").
                then().
                assertThat().
                statusCode(500).
                and().
                contentType(ContentType.JSON);
        JsonPath jsonPath = RestAssured.get("/issues/XYZ/events").andReturn().jsonPath();
        assertEquals(MessageUtil.getMessage(MessageEnum.MSG003), jsonPath.get("message"));
    }

    @Test
    public void getAllSuccessfully() {
        given().
                header("content-type", "application/json").
                when().
                body(EVENT_CREATED).
                when().
                get("/issues/5/events").
                then().
                assertThat().
                statusCode(200);
    }

    private static final String EVENT_CREATED = "[\n" +
            "    {\n" +
            "        \"action\": \"closed\",\n" +
            "        \"created_at\": \"2020-03-24T19:40:13Z\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"action\": \"opened\",\n" +
            "        \"created_at\": \"2020-03-24T19:40:02Z\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"action\": \"closed\",\n" +
            "        \"created_at\": \"2020-03-24T19:40:13Z\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"action\": \"opened\",\n" +
            "        \"created_at\": \"2020-03-24T19:40:02Z\"\n" +
            "    }\n" +
            "]";

    private static final String WEBHOOK_JSON = "{\n" +
            "  \"zen\": \"Speak like a human.\",\n" +
            "  \"hook_id\": 194546886,\n" +
            "  \"hook\": {\n" +
            "    \"type\": \"Repository\",\n" +
            "    \"id\": 194546886,\n" +
            "    \"name\": \"web\",\n" +
            "    \"active\": true,\n" +
            "    \"events\": [\n" +
            "      \"*\"\n" +
            "    ],\n" +
            "    \"config\": {\n" +
            "      \"content_type\": \"form\",\n" +
            "      \"insecure_ssl\": \"0\",\n" +
            "      \"url\": \"http://81ddd90c.ngrok.io/events\"\n" +
            "    },\n" +
            "    \"updated_at\": \"2020-03-24T19:41:28Z\",\n" +
            "    \"created_at\": \"2020-03-24T19:41:28Z\",\n" +
            "    \"url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/hooks/194546886\",\n" +
            "    \"test_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/hooks/194546886/test\",\n" +
            "    \"ping_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/hooks/194546886/pings\",\n" +
            "    \"last_response\": {\n" +
            "      \"code\": null,\n" +
            "      \"status\": \"unused\",\n" +
            "      \"message\": null\n" +
            "    }\n" +
            "  },\n" +
            "  \"repository\": {\n" +
            "    \"id\": 245735343,\n" +
            "    \"node_id\": \"MDEwOlJlcG9zaXRvcnkyNDU3MzUzNDM=\",\n" +
            "    \"name\": \"jogo-arrocha-react\",\n" +
            "    \"full_name\": \"vagnerbarbosa/jogo-arrocha-react\",\n" +
            "    \"private\": false,\n" +
            "    \"owner\": {\n" +
            "      \"login\": \"vagnerbarbosa\",\n" +
            "      \"id\": 1761682,\n" +
            "      \"node_id\": \"MDQ6VXNlcjE3NjE2ODI=\",\n" +
            "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/1761682?v=4\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/vagnerbarbosa\",\n" +
            "      \"html_url\": \"https://github.com/vagnerbarbosa\",\n" +
            "      \"followers_url\": \"https://api.github.com/users/vagnerbarbosa/followers\",\n" +
            "      \"following_url\": \"https://api.github.com/users/vagnerbarbosa/following{/other_user}\",\n" +
            "      \"gists_url\": \"https://api.github.com/users/vagnerbarbosa/gists{/gist_id}\",\n" +
            "      \"starred_url\": \"https://api.github.com/users/vagnerbarbosa/starred{/owner}{/repo}\",\n" +
            "      \"subscriptions_url\": \"https://api.github.com/users/vagnerbarbosa/subscriptions\",\n" +
            "      \"organizations_url\": \"https://api.github.com/users/vagnerbarbosa/orgs\",\n" +
            "      \"repos_url\": \"https://api.github.com/users/vagnerbarbosa/repos\",\n" +
            "      \"events_url\": \"https://api.github.com/users/vagnerbarbosa/events{/privacy}\",\n" +
            "      \"received_events_url\": \"https://api.github.com/users/vagnerbarbosa/received_events\",\n" +
            "      \"type\": \"User\",\n" +
            "      \"site_admin\": false\n" +
            "    },\n" +
            "    \"html_url\": \"https://github.com/vagnerbarbosa/jogo-arrocha-react\",\n" +
            "    \"description\": \"Created with CodeSandbox\",\n" +
            "    \"fork\": false,\n" +
            "    \"url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react\",\n" +
            "    \"forks_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/forks\",\n" +
            "    \"keys_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/keys{/key_id}\",\n" +
            "    \"collaborators_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/collaborators{/collaborator}\",\n" +
            "    \"teams_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/teams\",\n" +
            "    \"hooks_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/hooks\",\n" +
            "    \"issue_events_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/issues/events{/number}\",\n" +
            "    \"events_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/events\",\n" +
            "    \"assignees_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/assignees{/user}\",\n" +
            "    \"branches_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/branches{/branch}\",\n" +
            "    \"tags_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/tags\",\n" +
            "    \"blobs_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/git/blobs{/sha}\",\n" +
            "    \"git_tags_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/git/tags{/sha}\",\n" +
            "    \"git_refs_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/git/refs{/sha}\",\n" +
            "    \"trees_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/git/trees{/sha}\",\n" +
            "    \"statuses_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/statuses/{sha}\",\n" +
            "    \"languages_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/languages\",\n" +
            "    \"stargazers_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/stargazers\",\n" +
            "    \"contributors_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/contributors\",\n" +
            "    \"subscribers_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/subscribers\",\n" +
            "    \"subscription_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/subscription\",\n" +
            "    \"commits_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/commits{/sha}\",\n" +
            "    \"git_commits_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/git/commits{/sha}\",\n" +
            "    \"comments_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/comments{/number}\",\n" +
            "    \"issue_comment_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/issues/comments{/number}\",\n" +
            "    \"contents_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/contents/{+path}\",\n" +
            "    \"compare_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/compare/{base}...{head}\",\n" +
            "    \"merges_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/merges\",\n" +
            "    \"archive_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/{archive_format}{/ref}\",\n" +
            "    \"downloads_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/downloads\",\n" +
            "    \"issues_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/issues{/number}\",\n" +
            "    \"pulls_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/pulls{/number}\",\n" +
            "    \"milestones_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/milestones{/number}\",\n" +
            "    \"notifications_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/notifications{?since,all,participating}\",\n" +
            "    \"labels_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/labels{/name}\",\n" +
            "    \"releases_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/releases{/id}\",\n" +
            "    \"deployments_url\": \"https://api.github.com/repos/vagnerbarbosa/jogo-arrocha-react/deployments\",\n" +
            "    \"created_at\": \"2020-03-08T01:52:33Z\",\n" +
            "    \"updated_at\": \"2020-03-08T01:52:39Z\",\n" +
            "    \"pushed_at\": \"2020-03-08T01:52:37Z\",\n" +
            "    \"git_url\": \"git://github.com/vagnerbarbosa/jogo-arrocha-react.git\",\n" +
            "    \"ssh_url\": \"git@github.com:vagnerbarbosa/jogo-arrocha-react.git\",\n" +
            "    \"clone_url\": \"https://github.com/vagnerbarbosa/jogo-arrocha-react.git\",\n" +
            "    \"svn_url\": \"https://github.com/vagnerbarbosa/jogo-arrocha-react\",\n" +
            "    \"homepage\": \"https://codesandbox.io/s/github/vagnerbarbosa/jogo-arrocha-react\",\n" +
            "    \"size\": 2,\n" +
            "    \"stargazers_count\": 0,\n" +
            "    \"watchers_count\": 0,\n" +
            "    \"language\": \"JavaScript\",\n" +
            "    \"has_issues\": true,\n" +
            "    \"has_projects\": true,\n" +
            "    \"has_downloads\": true,\n" +
            "    \"has_wiki\": true,\n" +
            "    \"has_pages\": false,\n" +
            "    \"forks_count\": 0,\n" +
            "    \"mirror_url\": null,\n" +
            "    \"archived\": false,\n" +
            "    \"disabled\": false,\n" +
            "    \"open_issues_count\": 1,\n" +
            "    \"license\": null,\n" +
            "    \"forks\": 0,\n" +
            "    \"open_issues\": 1,\n" +
            "    \"watchers\": 0,\n" +
            "    \"default_branch\": \"master\"\n" +
            "  },\n" +
            "  \"sender\": {\n" +
            "    \"login\": \"vagnerbarbosa\",\n" +
            "    \"id\": 1761682,\n" +
            "    \"node_id\": \"MDQ6VXNlcjE3NjE2ODI=\",\n" +
            "    \"avatar_url\": \"https://avatars1.githubusercontent.com/u/1761682?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/vagnerbarbosa\",\n" +
            "    \"html_url\": \"https://github.com/vagnerbarbosa\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/vagnerbarbosa/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/vagnerbarbosa/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/vagnerbarbosa/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/vagnerbarbosa/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/vagnerbarbosa/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/vagnerbarbosa/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/vagnerbarbosa/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/vagnerbarbosa/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/vagnerbarbosa/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  }\n" +
            "}";
}