Création d'un utilisateur "applicatif" sous JBoss AS 7.1.1
==========================================================
[Référence : https://docs.jboss.org/author/display/AS71/add-user+utility]

1- Se dépalcer sous %JBOSS_HOME%\bin
2- En mode non interactif : Lancer l'utilitaire add-user et lui fournir le username et le mot de passe
        add-user.bat -a {username} {password}
   En mode interactif :
   Lancer l'utilitaire add-user.bat,
   Un menu vous sera proposé
      What type of user do you wish to add?
      a) Management User (mgmt-users.properties)
      b) Application User (application-users.properties)
      
      Choisir l'option b (Applicationn User), puis introduire interactivement
      le username et le mot de passe 