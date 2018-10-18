I think part of my problem with the Simple API is that not all
elements are allowed to be direct children of a given element. For
instance, I don't think that a list element can directly contain a
paragraph, for instance. 

Yeah, I think this is the case. There are a few interfaces called
container, like "ListContainer", "FormContainer", "FrameContainer". In
fact, here are the containers:

- AbstractChartContainer
    - PresentationDocument
    - Slide
    - SpreadsheetSlide
    - TextDocument
- AbstractFormContainer
- AbstractFrameContainer
- AbstractListContainer
    - Cell
    - ListItem
    - Notes
    - Section
    - Slide
    - Textbox
    - TextDocument
- AbstractParagraphContainer
    - Cell
    - Section
    - Textbox
    - TextDocument
- AbstractTableContainer
    - ChartDocument
    - Document
    - Footer
    - GraphicsDocument
    - Header
    - PresentationDocument
    - Section
    - Slide
    - SpreadsheetDocument
    - TextDocument
- AbstractTextboxContainer
- AbstractVariableContainer

So, lists, paragraphs, and tables can only go in particular elements.
Though, based on looking at the actual structure of a list, paragraphs
can go in ListItem, too.
