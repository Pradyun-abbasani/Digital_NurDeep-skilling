import logo from './logo.svg';
import './App.css';
// src/App.js
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore 
        Name={"Steeve"} 
        School={"DNV Public School"} 
        total={284} 
        goal={3} 
      />
    </div>
  );
}

export default App;
