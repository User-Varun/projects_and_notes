
- installing the multiple version of app ( notes app and notes app demo ) will use the same local db ( I can change the sqlite db name in the demo app , problem will be resolved I can do that in later release ) 

- users can create the same note twice by saving it twice  #solved
    
- the UI jumps ( padding gets added or reduced ) when add notes ( need to look how to reproduce it ) #solved
    
- in detailed note view if the note is long it will overflown and will be cut coz the area is not scrollable
    
- when we type note ( edit or create ) the notes don't auto scroll when type and due to that the text get hidden under the keyboard ( have to use manual scroll and enter button on keyboard to increase height of text area
    
- when we click on back button ( if note is unsaved ( if we click on cancel of save the note doesn't redirect us to the home page , or maybe it should redirect to the detailed note screen with updated note details )
    
- the note description in the homeScreen doesn't get clipped (read me ... ) and when we use space  (and due to this the note height get larger and look weird)  

# side note

- also have to create a test db working for giving the demo of app to customers
    
- also learn to, update the app ( like bug fix update and others )