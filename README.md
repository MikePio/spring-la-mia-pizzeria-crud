# `spring-la-mia-pizzeria-crud`

## Todo
## `Giorno 1 - index, layout, spring jpa`
Realizzare un gestionale per una pizzeria. 

Abbiamo bisogno di creare la prima pagina (`index`) dove mostriamo **tutte le pizze che prepariamo**.

Una **pizza** avrà le seguenti informazioni:
- `nome`
- `descrizione`
- `foto` (url)
- `prezzo`

Creiamo il `database`, `model`, `repository` e `service` per gestire le **CRUD** delle pizze.

Implementare inoltre il `CommandLineRunner` come visto a lezione per caricare alcuni **dati fake**.

Implementiamo  quindi il **controller** con il metodo `index` che restituisce una **view** per mostrare **l’elenco delle pizze caricate dal database**.

###ATTENZIONE

> L’elenco potrebbe essere vuoto
> In quel caso dobbiamo mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella nostra applicazione. 
> 
> Testare anche questa eventualita' commentando gli inserimenti nel `CommandLineRunner`.

Gestiamo i componenti riutilizzabili con i `fragments`.

## `Day 2 - Show + Filter`

Lo scopo di oggi è quello di mostrare i dettagli di una singola pizza.

Ogni pizza dell’elenco avrà quindi un pulsante che se cliccato ci porterà a una pagina che mostrerà i dettagli della pizza scelta.

Dobbiamo quindi inviare l’`id` come parametro dell’`URL`, recuperarlo nel metodo del `controller`, caricare i dati della **pizza ricercata** e passarli come `model`.

La `view` a quel punto li mostrerà all’utente con la grafica che preferiamo.

Nella pagina con l’elenco delle pizze aggiungiamo un campo di testo che se compilato filtrerà le pizze (**lato server**) aventi come `titolo` quello inserito dall’utente.