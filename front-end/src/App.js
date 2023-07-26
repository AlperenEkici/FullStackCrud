import './App.css';
import Navbar from './layout/Navbar';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Dashboard from './pages/Dashboard';
function App() {
  return (
    <div className="App">
        <Navbar />
        <Dashboard/>
    </div>
  );
}

export default App;
