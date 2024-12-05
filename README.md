Lab 2: Sistem de Detectare a Schimbărilor în Fișiere

Acesta este un proiect educațional creat în Java, care implementează un sistem de detectare a schimbărilor în fișiere, similar cu funcționalitățile unui sistem de control al versiunilor (VCS). Proiectul permite monitorizarea și gestionarea modificărilor dintr-un director specificat în timp real.

Structura Proiectului

Pachetul lab_2

Clase principale:

Main

Punctul de intrare al aplicației. Inițializează sistemul de snapshot, repository-ul și bucla principală de execuție a aplicației.

AppLoop (lab_2.behavior)

Gestionează interfața interactivă cu utilizatorul, permițând acestuia să interacționeze cu sistemul.

Document (lab_2.files)

Reprezintă fișierele monitorizate. Clasele derivate pot extinde această clasă pentru a sprijini diferite tipuri de fișiere (text, imagini, fișiere de cod).

Repository (lab_2.tracker)

Menține lista fișierelor monitorizate și gestionează operațiunile de verificare a modificărilor.

SnapshotSys (lab_2.tracker)

Gestionează funcționalitatea de snapshot și oferă posibilitatea de a compara starea fișierelor la momente diferite.

