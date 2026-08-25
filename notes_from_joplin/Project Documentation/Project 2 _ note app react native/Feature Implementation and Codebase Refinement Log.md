# Currently in process :-

- [ ] <span style="color: rgb(206, 212, 217);">solve the spaghetti code problem ( duplicate code leading to undesirable conditions and behaviors) (make everything as separate as possible , make parts reusable where needed or duplicate code is found)</span>
- [ ] <span style="color: rgb(206, 212, 217);">think about making the SRS document for this project</span>

&nbsp;

# Extra Features (desirables ) :-

- edit or delete note through the search results (when searching for notes)

&nbsp;

# Done and implemented :-

- [x] handle edit , when user clicks on edit button on detailed view screen ( currently I'm sending user to createEditNote screen note and isEditing property i can handle that there , this editingproperty is getting handled at createEditNote screen on handleSave and handleSaveAndGoBack fn ( will have to create the update fn in api.js )
- [x] the alert when going back without saving functionality is currently work in progress ( have to style the alert ui and map the discard and save button accordingly
- [x] the search functionality is yet to be implemented on the api as well as to map on ui
- [x] delete note functionality is also missing yet
- [x]  update note fn in api.js
- [x] search
- [x] delete note
- [x] <span style="color: rgb(206, 212, 217);">implement local db SQLite for local storage in mobile (everything will fetch from the local storage , and in case of create, edit, update note, I'll update the local db from my created api ( that will massively increase the responsiveness , and that's how modern apps do it )</span>
- [x] <span style="color: rgb(206, 212, 217);">remove alerts from the app , it's looks ugly and annoying , instead i can make the the buttons make responsive to change</span>

# <span style="color: rgb(206, 212, 217);">three changes to get to version (2.0) --implemented</span>

- [x] <span style="color: rgb(206, 212, 217);">the ui jumping to top ( looking ugly )</span>
- [x] <span style="color: rgb(206, 212, 217);">implementation of local db</span>
- [x] <span style="color: rgb(206, 212, 217);">change of those ugly alert with modern modal cards</span>
- [x] <span style="color: rgb(206, 212, 217);">update the ui automatically when create , update or delete note ( already done for delete note i believe. ( problem solved )</span>