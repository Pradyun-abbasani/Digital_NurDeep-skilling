
import './App.css';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersList from "./TrainersList";
import TrainerDetails from "./TrainerDetails";
import trainersMock from "./trainersMock";

function App() {
  return (
    <div>
      <h1>My Academy Trainers App</h1>
      <nav>
        <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
        <Route path="/trainer/:id" element={<TrainerDetails trainers={trainersMock} />} />
      </Routes>
    </div>
  );
}

export default App;
