## June 13 , 2025 ( version 1.0 )

* * *

- making the Youtube  part working

&nbsp;

## June 14 , 2025 ( version 1.0 )

* * *

- working on the UI of the extension ( making it look pretty )
- <img src="../../../_resources/a9aecd2a8998971275c70b9515aec129.png" alt="a9aecd2a8998971275c70b9515aec129.png" width="205" height="284" class="jop-noMdConv"> Current UI

&nbsp;

## June 15, 2025 (version 1.0)

* * *

- UI is functional , but improvements needs , like quality if life changes
- <img src="../../../_resources/914cedf74023d48121c3920f28200de4.png" alt="914cedf74023d48121c3920f28200de4.png" width="98" height="145" class="jop-noMdConv">   current UI
- the basic navigating to Youtube video on button click also working, now needs to workout how to making it lunch the video at specific time Stamps
- done with the Youtube functionality ( open video at given time Stamp )
- now just need to add the remove card button
- and beautify the UI

&nbsp;

- [x]  now first make renderLayout FN , that render renderCards in itself and if not that render the starter Message (done)
- [x] add done and a tick after successful marker , (done )
- [x]  beautify the layout for new users ( done )
- [x]  changed the button to "marked", if  the marker is already there ( done )
- [x]  allow users to add multiple bookmarks for the same video ( done )

## June 16 , 2025 ( version 1.0 )

* * *

- [x] add delete marker icon ( like red bin , Instagram style) ( done )
- [x] add delete marker  functionality ( done ) 
- [x] beautified the Ui ( added new icons , added new styles ) 

&nbsp;

&nbsp;

## Bugs Encountered :-

* * *

### Bug 1:- 

&nbsp;      Problem :- when user marks a video , then delete it and then again marks a video                             on other timestamp of the same video without reloading the Youtube                                 page, then.. when user tries to delete any of the  marker, both marker                               gets deleted.

&nbsp;      probable reason :- I'm using cache to store the marker temporarily , in the `contentScript.js ` 

&nbsp;  

### Bug 2 :- 

&nbsp;   problem :- when user marks a video , then deletes the same video , the button on                             Youtube page still show marked status and not let set marker to that same                       place until Youtube page is refreshed.

&nbsp;    probable Reason :- unknown yet

&nbsp; 

### Features to add in future :-

* * *

- thing about add security(encryption) and functionality to export your data
- add a getting started video describing how to this extension

&nbsp;

&nbsp;