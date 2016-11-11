@Test
public void should_be_able_to_login_with_credentials() {
  givenThat(anna).wasAbleTo(openTheMeetUpWebsite);
  when(anna).wasAbleTo(browseToTheLoginPage);
    and(anna).attemptsTo(LogIn.withCredentials());
  then(anna).should(eventually(seeThat(theUserAvatarIsVisible)));
}
