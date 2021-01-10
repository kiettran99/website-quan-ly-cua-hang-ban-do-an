import React, { useEffect, useState } from "react";
import {
    CButton,
    CModal,
    CModalHeader,
    CModalBody,
    CModalFooter,
    CContainer,
    CRow,
    CCol,
    CImg,
} from "@coreui/react";
import alertify from "alertifyjs";
import { getAllLoaiMonAn, editLoaiMonAn } from '../api/LoaiMonAnApi';

const EditLoaiMonAn = (props) => {
    const [ten, setTen] = useState();
    const { selectLoaiMonAn, editModal, toggleEditModal, createSuccess } = props;

    useEffect(() => {
        setTen(selectLoaiMonAn.lma_ten);
    }, [selectLoaiMonAn]);

    const onSubmit = async (e) => {
        e.preventDefault();
        
        const data = {
            ma_ten: ten
        }

        // const formData = new FormData();

        // formData.append('ma_ten', ten);
        // formData.append('ma_giavon', giavon);
        // formData.append('ma_giaban', giaban);
        // formData.append('ma_donvitinh', dvt);
        // formData.append('ma_motachitiet', motachitiet);
        // formData.append('image', hinhanh);

        try {
            await EditLoaiMonAn(selectLoaiMonAn.lma_id, data);
            toggleEditModal();
            createSuccess();
            alertify.success("Thêm món ăn thành công");
        } catch (err) {
            alertify.error("Lỗi nghen");
        }
    }

    return (
        <div className='create-food'>
            <CModal show={editModal} onClose={toggleEditModal} size="md">
                <CModalHeader closeButton>
                    <h3>Sửa loại món ăn</h3>
                </CModalHeader>
                <form onSubmit={onSubmit}>
                    <CModalBody className="create-food-content">
                        <CRow className="field">
                            <CCol lg="10">
                                <CRow>
                                    <CCol lg="5" className="pt-2">
                                        Tên món ăn
                    </CCol>
                                    <CCol>
                                        <input
                                            type="text"
                                            placeholder="Nhập tên loại món ăn ăn"
                                            className="form-control"
                                            value={ten}
                                            onChange={(e) => {
                                                setTen(e.target.value);
                                            }}
                                            style={{ width: "100%" }}
                                            required
                                        />
                                    </CCol>
                                </CRow>
                            </CCol>
                        </CRow>
                    </CModalBody>
                    <CModalFooter>
                        <CButton color="primary" type="submit">
                            Cập nhật
            </CButton>
                        <CButton color="secondary" onClick={props.toggleModal}>
                            Bỏ qua
            </CButton>
                    </CModalFooter>
                </form>
            </CModal>
        </div>
    );
};

export default EditLoaiMonAn;
