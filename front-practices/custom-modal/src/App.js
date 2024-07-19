import './styles.css';
import React, {useState} from 'react';
import Modal from "./Modal";
function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <div className="App">
      <h1>React Custom Modal Example</h1>
      <button onClick={openModal}>Open Modal</button>
      {isModalOpen && (
        <Modal closeModal={closeModal}>
          <h2>Custom Modal Content</h2>
          <p>This is a custom modal implemented in React.</p>
          <button onClick={closeModal}>Close Modal</button>
        </Modal>
      )}
    </div>
  );
}
export default App;
