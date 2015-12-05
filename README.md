# Cube  
  
While a cube is normally thought of as 6 faces, it would be difficult and tedious to implement cube solving with this representation.  Instead, I represented a cube as the pieces it is physically made of (see https://upload.wikimedia.org/wikipedia/commons/f/fa/Disassembled-rubix-1.jpg). A cube is composed of 6 centers, 12 edges, and 8 corners. Each edge piece has 2 colors, and each corner has 3 colors.  
  
I kept three arrays, one for each type of piece. Each index within the array is a position on the cube (I arbitrarily defined which index represents what position on the cube). Within a position, both centers and edges have different possible orientations. So within a piece object, I also had to keep track of what orientation state the piece is in. For a solved cube, each piece's orientation is 0. Thus, a piece's orientation is relative to the solved orientation of that piece. Using this representation, implementing turning is a combination of manipulating the positions (pretty straightforward) and the orientations (a lot of trial and error and debugging was involved).  
  
