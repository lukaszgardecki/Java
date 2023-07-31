To jest serwis (serwer), który pobiera propertisy z repozytorium zdalnego.
Na repozytorium zdalnym zostały zapisane pliki:
 - application.yml (domyślny)
 - application-dev.yml (profil dev)
 - application-prod.yml (profil prod)

Serwis klient powinien mieć zdefiniowany w sobie propertis, okreslający config.server, a dokładniej link do repozytorium zdalnego i czy powinno clonować repozytorium przy starcie.