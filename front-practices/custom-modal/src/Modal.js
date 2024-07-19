// src/components/Modal.js
import React from 'react';
import './Modal.css'; // 스타일을 위한 CSS 파일

const Modal = ({ closeModal, children }) => {
  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <button className="modal-close" onClick={closeModal}>×</button>
        {children}
      </div>
    </div>
  );
};

export default Modal;
