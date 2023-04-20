CS5004   
2023 spring semester   
Boston  
Yunmu Shu

# Homework 9: Shapes Photo Album

## Changes for homework 8:

### For entity:

Added getPara and getType two method in Oval and rectangle class to interact with
web html.

### For Model:

Instead of using linkedHashMap, I decided to store the description and SnapShot id
and List into a class, then I use list to store this class which can also realize
linkedHashMap(encapsulation the key-value into a class and this class is generics
of the list).

## New in homework 9

### For View:

GenerateWindow class used java swing to generate the window to show image. Graphic class
designed the UI and bing listener to button. MyCloseListener is being bind with quit button.
Web class appended svg label to the file and output it as html.

### For controller:

fileReader class match the file in Regular Expression. ShapeController interface supplied
the api to use the shapeModel function that been written before. ShapeControllerImpl implemented
these api. GraphicController and WebController is to get the output and initialize it.

### For test:

test input file buildings.txt and demo_input.txt

## References

1. JPanel, "https://docs.oracle.com/javase/tutorial/uiswing/components/panel.html"
2. Frame, "https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html"
3. Dialog, "https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html"
4. SVG, "https://www.w3school.com.cn/svg/index.asp"
5. ScorePane, "https://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html"